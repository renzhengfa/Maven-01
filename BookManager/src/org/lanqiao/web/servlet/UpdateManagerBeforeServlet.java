package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 携带uid确保是本人操作
 */

@WebServlet("/updateManagerBefore")
public class UpdateManagerBeforeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String struid = request.getParameter("currentUid");
		int uid = Integer.parseInt(struid);
		request.getSession().setAttribute("updatemanagerBycurrentUid", uid);
		response.sendRedirect(request.getContextPath() + "/management/updateManager.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
