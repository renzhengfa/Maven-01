package org.lanqiao.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.Book;
import org.lanqiao.bean.User;
import org.lanqiao.service.BookService;
import org.lanqiao.service.UserService;
import org.lanqiao.service.User_consumeService;
import org.lanqiao.serviceImpl.BookServiceImpl;
import org.lanqiao.serviceImpl.UserServiceImpl;
import org.lanqiao.serviceImpl.User_consumeServiceImpl;
import org.lanqiao.utils.DownloadUtil;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//获取页面的uuid
		String uuid = request.getParameter("uuid");
		//获取session存的uuid
		String bookinfouuid = (String) request.getSession().getAttribute("bookinfouuid");
		if(uuid == null) {
			// 请重新前往首页在进入页面下载
			request.setAttribute("errorinfo", "请重新前往首页在进入页面下载");
			request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
			return;
		}
		if(bookinfouuid == null) {
			// 请重新前往首页在进入页面下载
			request.setAttribute("errorinfo", "请重新前往首页在进入页面下载");
			request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
			return;
		}
		if(!uuid.equals(bookinfouuid)) {
			// 频繁刷新
			request.setAttribute("errorinfo", "请不要频繁刷新");
			request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
			return;
		}else {
			//清空之前的session
			bookinfouuid = null;
			// 获取登录的session
			User user = (User) request.getSession().getAttribute("isLogined");
			// 处理页面参数
			String strBid = request.getParameter("bid");
			int bid = Integer.parseInt(strBid);
			// 根据图书id查询图书信息
			BookService bookservice = new BookServiceImpl();
			Book book = bookservice.queryBookById(bid);
			String bookPath = null;
			if(book != null) {
				/*
				 * 获得图书的路径
				 */
				String bookName = book.getName();
//			bookName = new String(bookName.getBytes("ISO8859-1"), "utf-8");
				bookPath = "/bookes/txts/" + bookName + ".txt";
				request.setAttribute("book", book);
			}
			if (user == null) {
				// 还未登录(默认为游客不可以下载图书,可以查看图书)
				request.setAttribute("errorinfo", "您未登录,请先登录,如未注册,请先注册在登录即可下载.");
				
				request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
			} else {
				//userservice
				UserService userService = new UserServiceImpl();
				// 判断是否可以下载(status为1时可以下载,为2时下架了)
				String status = book.getStatus();
				if (status.equals("1")) {
					/*
					 * 可以下载 1.判断是否vip用户 2.根据是否vip判断下载次数给出对应得提示
					 */
					String vip = user.getVip();
					
					// 获取当前时间及格式化
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String created = format.format(date);
					
					if (vip.equals("1")) {// 是vip,可以永久无线次下载
						// 获取图书是否为付费下载
						boolean consumption = bookservice.isConsumption(book.getBid());
						if (consumption) {//付费图书下载
							// 获取图书金额
							double price = book.getPrice();
							// 付费图书打9折
							double money = price * 0.9;
							if (user.getMoney() >= money) {// 余额充足
								int i = bookservice.vipdownload(bid, user.getUid(), created, money);// 判断数据库是否操作完毕
								int j = userService.consumption(user.getUid(), money);//减少余额
								
								/*
								 * 1.下载代码
								 */
								if (i != 0 && j != 0) {
									
									DownloadUtil.downLoad(bookPath, request, response);
									
									//response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
								}else {//下载失败???
									request.setAttribute("errorinfo", "下载失败.");
									request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
								}
							} else {// 余额不足
								request.setAttribute("errorinfo", "余额不足,请先充值.");
								request.setAttribute("book", book);
								request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
							}
						} else {//其他图书下载
							// 获取图书金额
							double price = book.getPrice();
							// 其他书打8折
							double money = price * 0.8;
							if (user.getMoney() >= money) {// 余额充足
								int i = bookservice.download(bid, user.getUid(), created, money);// 判断数据库是否操作完毕
								int j = userService.consumption(user.getUid(), money);//减少余额
								
								
								/*
								 * 2.下载代码
								 */
								if (i != 0 && j != 0) {
									
									DownloadUtil.downLoad(bookPath, request, response);
									
									//response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
								}else {//下载失败???
									request.setAttribute("errorinfo", "下载失败.");
									request.setAttribute("book", book);
									request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
								}
							} else {// 余额不足
								request.setAttribute("errorinfo", "余额不足,请先充值.");
								request.setAttribute("book", book);
								request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
							}
						}
					}
					
					if (vip.equals("2")) {// 普通用户,只可以下载5次vip的书籍
						// 判断是否为付费书籍(true就是付费,false为不需要付费的)
						boolean isConsumption = bookservice.isConsumption(bid);
						// 获取付费书籍的下载次数
						User_consumeService user_consumeService = new User_consumeServiceImpl();
						int i = user_consumeService.queryUserVipDownloadsCounts(user.getUid());
						// System.out.println(i);
						if (isConsumption) {
							if(user.getMoney() >= book.getPrice()) {//余额大于单价
								if (i > 5) {
									// 跳转到图书详情页给出提示(您不是vip用户,要想下载更多图书请先成为vip用户.(免费5次已用完))
									request.setAttribute("errorinfo", "下载次数大于5次了,请先成为vip享下载功能.");
									request.setAttribute("book", book);
									request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
								} else {
									/*
									 * 可以下载
									 */
									//减少账户余额
									int k = userService.consumption(user.getUid(), book.getPrice());//减少余额
									int j = bookservice.vipdownload(bid, user.getUid(), created, book.getPrice());
									if(j != 0 && k != 0) {
										/*
										 * 3.下载代码
										 */
										
										DownloadUtil.downLoad(bookPath, request, response);
										
										//response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
									}else {//下载失败???
										request.setAttribute("errorinfo", "下载失败.");
										request.setAttribute("book", book);
										request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
									}
								}
							}else {
								//余额不足
								request.setAttribute("errorinfo", "余额不足,请先充值.");
								request.setAttribute("book", book);
								request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
							}
						}else {
							//不需要付费的图书
							if(user.getMoney() >= book.getPrice()) {//余额大于单价
								int k = userService.consumption(user.getUid(), book.getPrice());//减少余额
								int j = bookservice.download(bid, user.getUid(), created, book.getPrice());
								if(j != 0 && k != 0) {
									
									/*
									 * 4.下载代码
									 */
									
									DownloadUtil.downLoad(bookPath, request, response);
									//response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
								}else {//下载失败???
									request.setAttribute("errorinfo", "下载失败.");
									request.setAttribute("book", book);
									request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
								}
							}else {//余额不足
								request.setAttribute("errorinfo", "余额不足,请先充值.");
								request.setAttribute("book", book);
								request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
							}
						}
					}
				} else {
					// 图书已经下架
					request.setAttribute("errorinfo", "图书已下架,不可以下载图书.");
					request.setAttribute("book", book);
					request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
				}
			}
		}
		

		// response.getWriter().write(book.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
