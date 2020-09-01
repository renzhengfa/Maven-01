package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.User;
import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

@WebServlet("/registorCheckUser")
public class RegistorCheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		//获取页面传来的参数
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO8859-1"), "UTF-8");
		//判断用户名长度
		if(username.length() < 4 || username.length() > 12) {
			response.getWriter().write("{\"haveUserName\":"+ 2 + "}");
			return;
		}
		//根据用户名查询User信息
		UserService userservice = new UserServiceImpl();
		User user = userservice.queryUserByUserName(username);
		int countUser = 0;
		if(user != null) {
			//有这个人,不可以注册
			countUser = 1;
		}
		response.getWriter().write("{\"haveUserName\":"+ countUser + "}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
