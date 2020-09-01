package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.User;
import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

@WebServlet("/deleteManager")
public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码
		response.setContentType("text/html;charset=UTF-8");
		//判断该登录的人是否是超级管理员
		User user = (User) request.getSession().getAttribute("managerisLogined");
		int i = user.getRid();
		UserService userservice = new UserServiceImpl();
		List<User> allManager = userservice.queryAllManager(3);
		request.setAttribute("allManager", allManager);
		if(i == 4) {
			//获取页面参数
			String struid = request.getParameter("uid");
			int uid = Integer.parseInt(struid);
			//根据uid查询user的状态
			User user2 = userservice.queryUserByUid(uid);
			if(user2.getStatus().equals("1")) {//正常时才可以'删除'
				//是超级管理员,根据uid去“删除该管理员”
				int j = userservice.deleteUser(uid, "2");
				if(j != 0) {
					//删除成功
					request.setAttribute("alertInfo", "删除成功");
					request.getRequestDispatcher("/management/manageManager.jsp").forward(request, response);
				}else {
					//删除失败
					request.setAttribute("alertInfo", "删除失败");
					request.getRequestDispatcher("/management/manageManager.jsp").forward(request, response);
				}
			}else {
				//该用户已被删除
				request.setAttribute("alertInfo", "该用户已被删除");
				request.getRequestDispatcher("/management/manageManager.jsp").forward(request, response);
			}
		}else {
			//不是超级管理员
//			request.setAttribute("errorInfo", "您的权限不足");
			request.setAttribute("alertInfo", "您的权限不足");
			request.getRequestDispatcher("/management/manageManager.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
