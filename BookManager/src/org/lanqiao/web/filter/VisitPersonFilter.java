package org.lanqiao.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.User;
import org.lanqiao.service.UserService;
import org.lanqiao.serviceImpl.UserServiceImpl;

/*
 * 处理中文乱码页面的过滤器
 */

@WebFilter(urlPatterns= {"/jsp/personInfo.jsp", "/jsp/recharge.jsp","/toVip","/tovip.jsp"})
public class VisitPersonFilter implements Filter {

	public void destroy() {
		System.out.println("filter destory...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//先将request和response的数据类型转为HTTPServletRequest和HTTPServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//转码
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		//获取登录的session${sessionScope.isLogined.username }
		User user = (User) req.getSession().getAttribute("isLogined");
        if(user == null){//没有登录
            //如果session为空表示用户没有登陆就重定向到login.jsp页面
            //System.out.println("request.getContextPath()=" + request.getContextPath());  
            res.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
            return;
        }else {
        	//重新查询数据库
        	UserService userservice = new UserServiceImpl();
        	User user2 = userservice.queryUserByUserName(user.getUsername());
        	req.getSession().setAttribute("isLogined", user2);
        }
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init...");
	}

}
