package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.User;

@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取login的session
		User user = (User) request.getSession().getAttribute("isLogined");
		User user1 = (User) request.getSession().getAttribute("managerisLogined");
		//获取user类型
		if(user1 == null) {
			/*
			 * 普通用户退出登录
			 */
			request.getSession().setAttribute("isLogined",null);
			//返回首页
//		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
			return;
		}
		if(user == null) {
			/*
			 * 管理员或超级管理员退出登录
			 */
			//清空登录的session
			request.getSession().setAttribute("managerisLogined",null);
			//跳转到登录页面
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
