package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.bean.User;
import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		/*request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");*/
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO8859-1"), "UTF-8");
		String password = request.getParameter("password");
		password = new String(password.getBytes("ISO8859-1"), "UTF-8");
		String remenberPassword = request.getParameter("remenberPassword");
		String identifyingcode = request.getParameter("identifyingcode");
		//获取验证码的 session.setAttribute("verCode", verifyCode.toLowerCase()); 
		HttpSession session = request.getSession();
		String verCode = (String) session.getAttribute("verCode");
//		System.out.println(verCode);
		
		if(identifyingcode.equals(verCode)) {//验证码正确
			//登录
			UserService userservice = new UserServiceImpl();
			User user = userservice.login(username, password);
			if(user == null) {
				/*
				 * 登录失败,用户名或密码不正确(没有查到有这个人)
				 * 调回登录页面继续登录(存一个错误的cookie信息回显给用户)
				 */
				request.setAttribute("errorinfo", "登录失败,用户名或密码错误,请重试...");
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}else {
				//获取用户是否可用
				String status = user.getStatus();
				if(status.equals("1")) {
					/*
					 * 登录成功,跳转页面
					 * 1.管理员或超级管理员跳到后台管理系统
					 * 2.普通用户或vip跳转到前台系统
					 * 
					 * 判断是否是管理员:根据rid判断
					 * (1.普通用户 2.vip 3.管理员 4.超级管理员)
					 */
					
					request.setAttribute("errorinfo", "登录成功...");
					
					
					if(user.getRid() == 3 || user.getRid() == 4) {
						
						
						/*
						 * 是管理员或超级管理员
						 */
						if(remenberPassword != null) {
							/*
							 * 记住密码被√中
							 * 存Session
							 */
							request.getSession().setAttribute("remenberusername", username);
							request.getSession().setAttribute("remenberpassword", password);
						}else {
							/*
							 * 记住密码没有被√中
							 * 不存Session直接跳转到首页
							 * 清除Session
							 */
							request.getSession().setAttribute("remenberusername", null);
							request.getSession().setAttribute("remenberpassword", null);
						}
						HttpSession session2 = request.getSession();//获取login的session
						session2.setAttribute("managerisLogined",null);
//					System.out.println(session2.getAttribute("isLogined"));
						session2.setAttribute("managerisLogined", user);
//					System.out.println(session2.getAttribute("isLogined"));
						//跳转到后台页面
						/*
						 * 获取后台页面管理员数据
						 */
						List<User> allManager = userservice.queryAllManager(3);
						request.setAttribute("allManager", allManager);
						
						request.getRequestDispatcher("/management/manageManager.jsp").forward(request, response);
						
						
						
					}else {
						
						
						/*
						 * 是普通用户
						 */
						if(remenberPassword != null) {
							/*
							 * 记住密码被√中
							 * 存Session
							 */
							request.getSession().setAttribute("remenberusername", username);
							request.getSession().setAttribute("remenberpassword", password);
						}else {
							/*
							 * 记住密码没有被√中
							 * 不存Session直接跳转到首页
							 * 清除Session
							 */
							request.getSession().setAttribute("remenberusername", null);
							request.getSession().setAttribute("remenberpassword", null);
						}
						HttpSession session2 = request.getSession();//获取login的session
						session2.setAttribute("isLogined",null);
//					System.out.println(session2.getAttribute("isLogined"));
						session2.setAttribute("isLogined", user);
//					System.out.println(session2.getAttribute("isLogined"));
						//跳转到主页面
						response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
					}
				}else {//用户不可用,(该用户已经被管理员删除)
					request.setAttribute("errorinfo", "该用户已经被管理员删除...");
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
			}
		}else {//验证码错误
			request.setAttribute("errorinfo", "验证码错误...");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
