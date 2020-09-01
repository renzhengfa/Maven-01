package org.lanqiao.service;

import java.util.List;

import org.lanqiao.bean.Book;

/*
 * 服务分页时的接口
 * 1.根据当前页查询当前页的图书信息(默认一页为10本书):(queryBookByCurrentPageIndex(int curentPageIndex))
 * 2.查询所有图书本书:(int countBook())
 */

public interface PageBeanService {

	// 1.根据当前页查询当前页的图书信息
	List<Book> queryBookByCurrentPageIndex(int curentPageIndex, int currentPageProducts);

	// 2.查询所有图书本书:
	int countBook();

}
