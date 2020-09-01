package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rechargeBefore")
public class RechargeBeforeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//生成唯一的uuid码
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		System.out.println(uuid);
//		request.setAttribute("uuid", uuid);
		request.getSession().setAttribute("uuid", uuid);
		//转发
		request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
