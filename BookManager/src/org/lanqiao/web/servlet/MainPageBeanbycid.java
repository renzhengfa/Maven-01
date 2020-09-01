package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.Book;
import org.lanqiao.bean.PageBean;
import org.lanqiao.service.BookService;
import org.lanqiao.service.CategoryService;
import org.lanqiao.serviceImpl.BookServiceImpl;
import org.lanqiao.serviceImpl.CategoryServiceImpl;

@WebServlet("/mainPageBeanbycid")
public class MainPageBeanbycid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * 获取分类图书数据
		 */
		String strcid = request.getParameter("cid");
		int cid = 1;
		if(strcid != null) {
			cid = Integer.parseInt(strcid);
		}
		request.setAttribute("cid", cid);
		/*
		 * 获取页码数
		 */
		String indexstr = request.getParameter("index");
		if(indexstr == null) {
			indexstr = "1";//默认第一页
		}
		int index = Integer.parseInt(indexstr);
		
		//根据类型id查询类型名称
		CategoryService categoryservice = new CategoryServiceImpl();
		String cname = categoryservice.queryCnameByCid(cid);
		request.setAttribute("cname", cname);//图书类型
		
		//根据cid,index查询当前页图书
		BookService bookservice = new BookServiceImpl();
		//处理封装到pagebean
		//根据页码提取图书数据
		int totalproducts = bookservice.queryTotalProducts(cid);
		int pages = totalproducts / 10;
		if (totalproducts % 10 != 0) {
			pages = totalproducts / 10 + 1;//页数
		}
		
		int currentProducts = 10;//默认一页10本书
		if(index == pages && totalproducts % 10 != 0) {
			currentProducts = totalproducts % 10;
		}
		List<Book> currentbooklist = bookservice.queryBookByCid(cid, index, currentProducts);
		
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPageIndex(index);
		pagebean.setList(currentbooklist);
		pagebean.setPages(pages);
		pagebean.setCurrentPageProducts(currentProducts);
		pagebean.setTotalProducts(totalproducts);
		
		request.setAttribute("pagebean", pagebean);
		
		/*
		 * 封装排行榜数据
		 * SELECT * FROM book GROUP BY counts DESC LIMIT 0,7;
		 */
		List<Book> rankingList = bookservice.rankingList();
		request.setAttribute("rankingList", rankingList);
		
		
		//转发
		request.getRequestDispatcher("/jsp/indexbycid.jsp").forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
