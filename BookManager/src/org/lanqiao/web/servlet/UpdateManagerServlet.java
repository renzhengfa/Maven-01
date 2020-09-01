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

@WebServlet("/updateManager")
public class UpdateManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取页面传来的参数
		String struid = request.getParameter("currentUid");
		int currentUid = Integer.parseInt(struid);
		
		String tel = request.getParameter("tel").trim();
		String gendar = request.getParameter("gendar").trim();
		String email = request.getParameter("email").trim();
		
		//判断
		//电话号码是否全为数字
		for(int i = 0; i < tel.length(); i++) {
			if(!Character.isDigit(tel.charAt(i))) {
				request.setAttribute("errorinfo", "电话号码必须全为数字");
				request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
				return;
			}
		}
		if(tel.length() != 11) {
			request.setAttribute("errorinfo", "电话号码长度为11位");
			request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
			//处理,return
			return;
		}
		if(!(gendar.equals("男") || gendar.equals("女"))) {//密码不一致
			request.setAttribute("errorinfo", "亲,目前还没有这个性别噢,为您的想象力点赞...");
			request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
			//处理,return
			return;
		}
		
		//获取登录的人的id
		User user = (User) request.getSession().getAttribute("managerisLogined");
		int i = user.getUid();
		if(i != currentUid) {//不是本人,不可以修改
			request.setAttribute("errorinfo", "不是本人操作,不可以修改信息");
			request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
			//处理,return
			return;
		}
		//修改操作
		UserService userservice = new UserServiceImpl();
		int j = userservice.updateManager(currentUid, user.getPassword(), tel, email, gendar);
		if(j != 0) {
			//清空保存当前userid的session
			request.getSession().setAttribute("updatemanagerBycurrentUid", null);
			
			request.setAttribute("successinfo", "修改成功");
			request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
			//处理,return
			return;
		}else {
			request.setAttribute("errorinfo", "修改失败...");
			request.getRequestDispatcher("/management/updateManager.jsp").forward(request, response);
			//处理,return
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
