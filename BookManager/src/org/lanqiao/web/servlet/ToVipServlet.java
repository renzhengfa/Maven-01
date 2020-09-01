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

@WebServlet("/toVip")
public class ToVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面传来的参数
		String strmoney = request.getParameter("money");
		String strUid = request.getParameter("uid");
		
		//转为数字
		int money = Integer.parseInt(strmoney);
		int uid = Integer.parseInt(strUid);
		
		//成为会员
		UserService userservice = new UserServiceImpl();
		//根据用户id获取该用户的余额
		double havemuchmoney = userservice.muchMoney(uid);
		//判断余额是否充足
		if(havemuchmoney >= money) {
			//获取当前时间的字符串形式
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String created = format.format(date);
			//1.修改user的状态;2.添加消费记录
			int i = userservice.toVip(money*1.0, uid, created);
			//消费,扣除user表对应得钱
			int j = userservice.consumption(uid, money);
			//判断
			if(i != 0 && j != 0) {
				//成功成为会员
				request.setAttribute("alertInfo", "成为会员成功(支付成功)");
				//跳转到成为会员也
				request.getRequestDispatcher("/jsp/tovip.jsp").forward(request, response);
			}else {
				//成为会员失败
				request.setAttribute("alertInfo", "成为会员失败(支付失败)");
				//跳转到成为会员也
				request.getRequestDispatcher("/jsp/tovip.jsp").forward(request, response);
			}
		}else {
			//余额不足
			request.setAttribute("alertInfo", "余额不足,请先充值..");
			//跳转到成为会员也
			request.getRequestDispatcher("/jsp/tovip.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
