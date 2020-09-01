package org.lanqiao.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 用户的基类
 */

public class UserBase extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//处理乱码情况
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取当前对象的字节码文件
		Class<? extends UserBase> clazz = UserServlet.class;
		//获取方法
		String methodname = req.getParameter("methodname");
		try {
			Method method = clazz.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(clazz.newInstance(), req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
