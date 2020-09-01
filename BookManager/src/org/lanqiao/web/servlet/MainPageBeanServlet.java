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
import org.lanqiao.serviceImpl.BookServiceImpl;
import org.lanqiao.serviceImpl.PageBeanServiceImpl;

/*
 * 显示主页所有图书信息(分页显示)
 */

@WebServlet("/mainPageBean")
public class MainPageBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 获取当前页的图书信息
		 */
		response.setContentType("text/html;charset=UTF-8");
		
		
		/*
		 * 封装排行榜数据
		 * SELECT * FROM book GROUP BY counts DESC LIMIT 0,7;
		 */
		BookService bookservice = new BookServiceImpl();
		List<Book> rankingList = bookservice.rankingList();
		request.setAttribute("rankingList", rankingList);
		
		
		
		
		//获取页面请求传回的页码信息
		String strindex = request.getParameter("pageindex");
		if(strindex == null) {
			strindex = "1";//默认为第1页
		}
		//转为int类型
		int currentPageIndex = Integer.parseInt(strindex);//5.当前页索引
		PageBeanServiceImpl pagebeanService = new PageBeanServiceImpl();
		int totalProducts = pagebeanService.countBook();//1.统计数据库有多少本书
		int pages = (int) Math.ceil(1.0*totalProducts/10);//2.总页数
		//判断是否为最后一页(默认一页10本书)
		int currentPageProducts = 0;//3.当前页商品数目
		if(totalProducts % 10 != 0 && currentPageIndex == pages) {
			currentPageProducts = totalProducts % 10;
		}else {
			currentPageProducts = 10;//(默认一页10本书)
		}
		//4.根据当前页的页数查询当前页的图书信息
		List<Book> list = pagebeanService.queryBookByCurrentPageIndex(currentPageIndex, currentPageProducts);
		
		/*
		 * 封装数据
		 */
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPageIndex(currentPageIndex);
		pageBean.setCurrentPageProducts(currentPageProducts);
		pageBean.setList(list);
		pageBean.setPages(pages);
		pageBean.setTotalProducts(totalProducts);
		
		/*
		 * 存入request转发将数据传输到index.jsp页面
		 */
		request.setAttribute("pagebean", pageBean);
		//转发
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
