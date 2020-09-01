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

@WebServlet("/addManager")
public class AddManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面传来的参数
		request.setCharacterEncoding("UTF-8");
		/*
		 * 获取当前登录的user类型
		 * (4为超级管理员才可以真加或修改管理员的权限)
		 */
		User user1 = (User) request.getSession().getAttribute("managerisLogined");
		int j = user1.getRid();
		if(j == 4) {//超级管理员
			
			//获取页面传来的参数
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			/*
			 * 添加管理员(只有一个超级管理员)
			 * 先查看有没有重复的名称(7.根据用户名查询用户信息)
			 */
			UserService userservice = new UserServiceImpl();
			User user = userservice.queryUserByUserName(username);
			
			if(user == null) {
				//没有这个人的时候开始添加
				int i = userservice.addManager(username, password);
				if(i != 0) {
					/*
					 * 添加成功
					 * 跳回添加页面提示添加成功
					 */
					request.setAttribute("successInfo", "添加成功");
					request.getRequestDispatcher("/management/addManager.jsp").forward(request, response);
					return;
				}else {
					//添加失败
					request.setAttribute("failInfo", "添加失败");
					request.getRequestDispatcher("/management/addManager.jsp").forward(request, response);
					return;
				}
			}else {
				//有这个人
				//添加失败
				request.setAttribute("failInfo", "有这个人了已经");
				request.getRequestDispatcher("/management/addManager.jsp").forward(request, response);
				return;
			}
		}else {//不是超级管理员
			//权限不足
			request.setAttribute("failInfo", "您不是超级管理员,权限不足。");
			request.getRequestDispatcher("/management/addManager.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
