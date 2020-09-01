package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

@WebServlet("/registor")
public class RegistorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面传来的参数
		String username = new String(request.getParameter("username").getBytes("ISO8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("ISO8859-1"), "UTF-8");
		String tel = new String(request.getParameter("tel").getBytes("ISO8859-1"), "UTF-8");
		String email = new String(request.getParameter("email").getBytes("ISO8859-1"), "UTF-8");
		//sex radio
		String sex = new String(request.getParameter("sex").getBytes("ISO8859-1"), "UTF-8");
		String yanzhengma = new String(request.getParameter("yanzhengma").getBytes("ISO8859-1"), "UTF-8");
		
		//获取验证码注册session的值
		String verCode2 = (String) request.getSession().getAttribute("verCode2");
		if(verCode2 == null) {
			verCode2 = "";
		}
		
		//判断验证码是否正确
		if(verCode2.equals(yanzhengma)) {
			/*
			 * 验证码正确时
			 * 注册
			 */
			UserService userservice = new UserServiceImpl();
			//userservice.registor( username, password, telephone, sex, email, status, money, vip, rid, counts);
			int i = userservice.registor(username, password, tel, sex, email, "1", 0.0, "2", 1, 0);
			if(i != 0) {
				/*
				 * 注册成功
				 * 跳转到首页
				 */
				response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
			}else {
				/*
				 * 注册失败
				 */
				request.setAttribute("errorInfo", "注册失败...");
				//跳转到注册页面提示验证码错误
				request.getRequestDispatcher("/jsp/registor.jsp").forward(request, response);
			}
		}else {//验证码错误时
			request.setAttribute("errorInfo", "验证码错误...");
			//跳转到注册页面提示验证码错误
			request.getRequestDispatcher("/jsp/registor.jsp").forward(request, response);
		}
		
		request.getSession().getAttribute("verCode2");//注册验证码
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
