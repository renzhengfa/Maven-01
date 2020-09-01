package org.lanqiao.dao;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.Book;

/*
 * 分页时操作数据库的接口
 * 1.根据当前页查询当前页的图书信息(默认一页为10本书):(queryBookByCurrentPageIndex(int curentPageIndex))
 * 2.查询所有图书本书:(int countBook())
 */

public interface PageBeanDao {
	
	//1.根据当前页查询当前页的图书信息
	List<Book> queryBookByCurrentPageIndex(int curentPageIndex, int currentPageProducts) throws SQLException;
	
	//2.查询所有图书本书:
	int countBook() throws SQLException;
	
}
