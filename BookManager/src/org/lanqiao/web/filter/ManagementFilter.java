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

@WebFilter(urlPatterns= {"/management/updateManager.jsp","/management/addManager.jsp",
		"/management/bookManag.jsp","/management/financialManagement.jsp",
		"/management/manageManager.jsp","/management/addBook.jsp","/updateManager"
		,"/serchManager","/serchBook","/deleteManager","/financialManagement","/uploadImg"})
public class ManagementFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 要想进入后台管理系统必须是管理员及以上权限的人登录成功了才可以进入
		 * 1.获取登录的user的rid(3或者4可以进入)
		 */
		//转换类型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获取登录的人的角色id
		User user = (User) req.getSession().getAttribute("managerisLogined");
		if(user != null) {
			int rid = user.getRid();
			if(rid == 3 || rid == 4) {//是管理员及以上权限的人登录
				chain.doFilter(req, res);
				return;
			}else {//普通用户登录,跳转到登录页面登录
				req.setAttribute("errorinfo", "请先以管理员身份登录");
				req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
				return;
			}
		}else {//还未登录
			req.setAttribute("errorinfo", "请先以管理员身份登录");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
			return;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
