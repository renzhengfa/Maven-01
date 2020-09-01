package org.lanqiao.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.ConsumptionGson;
import org.lanqiao.service.User_consumeService;
import org.lanqiao.serviceImpl.User_consumeServiceImpl;

import com.google.gson.Gson;

@WebServlet("/financialManagement")
public class FinancialManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取页面参数
		String created = request.getParameter("date");
    	response.setCharacterEncoding("utf-8");
		if(created == null || created.equals("")) {
			//统计全部充值
			User_consumeService user_consumeService = new User_consumeServiceImpl();
			double sumRecharge = user_consumeService.sumRecharge();
			//统计全部消费
			double sumConsumption = user_consumeService.sumConsumption();
			//统计当前月份全部充值
			double sumMonthRecharge = user_consumeService.sumMonthRecharge("2018-11%");
			//统计当前月份全部消费
			double sumMonthConsumption = user_consumeService.sumMonthConsumption("2018-11%");
			
			ConsumptionGson consumption = new ConsumptionGson();
			consumption.setSumConsumption(sumConsumption);
			consumption.setSumRecharge(sumRecharge);
			consumption.setSumMonthConsumption(sumMonthConsumption);
			consumption.setSumMonthRecharge(sumMonthRecharge);
			request.setAttribute("consumption", consumption);
			request.getRequestDispatcher("/management/financialManagement.jsp").forward(request, response);
		}else {
			String[] createdArr = created.split("-");
			StringBuffer sb = new StringBuffer();
			sb.append(createdArr[0]).append("-").append(createdArr[1]);
			created = sb.toString();
			System.out.println(created);
			//统计全部充值
			User_consumeService user_consumeService = new User_consumeServiceImpl();
			double sumRecharge = user_consumeService.sumRecharge();
			//统计全部消费
			double sumConsumption = user_consumeService.sumConsumption();
			//统计当前月份全部充值
			double sumMonthRecharge = user_consumeService.sumMonthRecharge(created);
			//统计当前月份全部消费
			double sumMonthConsumption = user_consumeService.sumMonthConsumption(created);
			ConsumptionGson consumption = new ConsumptionGson();
			consumption.setSumConsumption(sumConsumption);
			consumption.setSumRecharge(sumRecharge);
			consumption.setSumMonthConsumption(sumMonthConsumption);
			consumption.setSumMonthRecharge(sumMonthRecharge);
			Gson gs = new Gson();
			//响应
            response.getWriter().write(gs.toJson(consumption));
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
