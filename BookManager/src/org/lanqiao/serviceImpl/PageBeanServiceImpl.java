package org.lanqiao.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.Book;
import org.lanqiao.dao.PageBeanDao;
import org.lanqiao.daoImpl.PageBeanDaoImpl;
import org.lanqiao.service.PageBeanService;

/*
 * 服务分页时的类
 * 1.根据当前页查询当前页的图书信息(默认一页为10本书):(queryBookByCurrentPageIndex(int curentPageIndex))
 * 2.查询所有图书本书:(int countBook())
 */

public class PageBeanServiceImpl implements PageBeanService {

	//创建DaoImpl层需要的对象
	PageBeanDao pageBeanDao = new PageBeanDaoImpl();
	
	//1.根据当前页查询当前页的图书信息(默认一页为10本书):
	@Override
	public List<Book> queryBookByCurrentPageIndex(int curentPageIndex, int currentPageProducts) {
		List<Book> list = null;
		try {
			list = pageBeanDao.queryBookByCurrentPageIndex(curentPageIndex, currentPageProducts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//2.查询所有图书本书:
	@Override
	public int countBook() {
		int i = 0;
		try {
			i = pageBeanDao.countBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
