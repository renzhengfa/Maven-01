package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.Book;
import org.lanqiao.bean.User;
import org.lanqiao.service.BookService;
import org.lanqiao.serviceImpl.BookServiceImpl;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//查询所有图书显示在页面上
		BookService bookservice = new BookServiceImpl();
		List<Book> allBook = bookservice.queryAllBook();
		request.setAttribute("allBook", allBook);
		//判断是否是超级管理员
		User manager = (User) request.getSession().getAttribute("managerisLogined");
		//获得管理员的rid
		int j = manager.getRid();
		if(j == 4) {//超级管理员
			//获取页面参数
			String strbid = request.getParameter("bid");
			//转化为int类型数据
			int bid = Integer.parseInt(strbid);
			
			//判断该书是否已经下架
			Book book = bookservice.queryBookById(bid);
			String status = book.getStatus();
			if(status.equals("1")) {//还未下架,可以下架
				//根据bid'去修改哪一本书的状态
				int i = bookservice.updateBookInfo(bid);
				if(i != 0) {
					//下架成功
					request.setAttribute("alertInfo", "下架成功");
					request.getRequestDispatcher("/management/bookManag.jsp").forward(request, response);
				}else {
					//下架失败
					request.setAttribute("alertInfo", "下架失败");
					request.getRequestDispatcher("/management/bookManag.jsp").forward(request, response);
				}
			}else {//已经下架,不可以再次下架
				//图书已经下架
				request.setAttribute("alertInfo", "该图书已经下架");
				request.getRequestDispatcher("/management/bookManag.jsp").forward(request, response);
			}
		}else {//一般管理员
			request.setAttribute("alertInfo", "您的权限不足");
			request.getRequestDispatcher("/management/bookManag.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
