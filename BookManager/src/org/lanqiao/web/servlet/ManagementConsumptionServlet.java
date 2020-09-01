package org.lanqiao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.User_consumeService;
import org.lanqiao.serviceImpl.User_consumeServiceImpl;

@WebServlet("/managementConsumption")
public class ManagementConsumptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User_consumeService user_consumeService = new User_consumeServiceImpl();
		double sumMonthProfit = user_consumeService.sumMonthConsumption("2018-11-1");
		System.out.println(sumMonthProfit);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
