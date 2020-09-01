package org.lanqiao.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieTest1")
public class CookieTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ªÒ»°cookie
		Cookie cookie = new Cookie("11", "11");
		response.addCookie(cookie);
//		request.getRequestDispatcher("/cookieTest2").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/cookieTest2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
