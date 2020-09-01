package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.Book;
import org.lanqiao.service.BookService;
import org.lanqiao.serviceImpl.BookServiceImpl;

@WebServlet("/bookInfo")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传来的bid参数
		String bid = request.getParameter("bid");
		//转为数字
		int id = Integer.parseInt(bid);
		//根据bid查询出图书信息转发到图书详情页
		BookService bookservice = new BookServiceImpl();
		Book book = bookservice.queryBookById(id);
		request.setAttribute("book", book);
		//生成一个uuid,确保用户频繁刷新
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		request.getSession().setAttribute("bookinfouuid", uuid);
		//转发
		request.getRequestDispatcher("/jsp/bookInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
