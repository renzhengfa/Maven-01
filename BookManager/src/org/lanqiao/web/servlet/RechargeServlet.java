package org.lanqiao.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

@WebServlet("/recharge")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//获取页面传来的参数
		
		String uuid = request.getParameter("uuid");
		//取出session内的uuid码
		String sesUuid = (String) request.getSession().getAttribute("uuid");
		
		if(sesUuid == null) {
			//不要频繁刷新
			request.setAttribute("alertinfo", "请耐心等待");
			//转发到充值页面
			request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
			return;
		}
		
		if(uuid == null) {
			//不要频繁刷新
			request.setAttribute("alertinfo", "请耐心等待");
			//转发到充值页面
			request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
			return;
		}
		
		if(!uuid.equals(sesUuid)) {
			//不要频繁刷新
			request.setAttribute("alertinfo", "请耐心等待");
			//转发到充值页面
			request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
			return;
		}
		
		if(uuid.equals(sesUuid)) {
			String username = request.getParameter("username");
			username = new String(username.getBytes("ISO8859-1"), "UTF-8");
			String strmoney = request.getParameter("money");
			strmoney = new String(strmoney.getBytes("ISO8859-1"), "UTF-8");
			String strUid = request.getParameter("uid");
			
			//字符串转化为数字
			int money = Integer.parseInt(strmoney);
			int uid = Integer.parseInt(strUid);
			
			//截取当前系统时间
			Date currentTime = new Date();
			//改变输出格式（自己想要的格式）
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//得到字符串时间
			String created = formatter.format(currentTime);
			//字符串转时间
			//DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			//System.out.println(created);
			
//		response.getWriter().write(username);//大白(中文可行)
			//充值操作
			UserService userservice = new UserServiceImpl();
			int i = userservice.recharge(username, money, uid, created);
			if(i != 0) {
				//充值成功
				request.setAttribute("alertinfo", "成功充值" + money + "金币");
			}else {
				//充值失败
				request.setAttribute("alertinfo", "充值失败");
			}
			
			
			/*
			 * 处理了就清除该cookie
			 */
			request.getSession().setAttribute("uuid", null);
			
			
			//转发到充值页面
			request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
			return;
		}else {
			//不要频繁刷新
			request.setAttribute("alertinfo", "请不要频繁刷新");
			//转发到充值页面
			request.getRequestDispatcher("/jsp/recharge.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
