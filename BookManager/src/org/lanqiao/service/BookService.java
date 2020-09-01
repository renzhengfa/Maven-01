package org.lanqiao.service;

import java.util.List;

import org.lanqiao.bean.Book;

/*
 * 服务图书表的接口
 * 
 * 1.查询全部图书:(queryAllBook())
 * 2.根据图书id查询单个图书:(queryBookById(int id))
 * 3.根据图书id查询图书是否付费
 * 4.下载
 * 5.vip下载
 */

public interface BookService {

	// 1.查询全部图书:(queryAllBook())
	List<Book> queryAllBook();

	// 2.根据图书id查询单个图书:(queryBookById(int id))
	Book queryBookById(int id);
	
	//3.根据图书id查询图书是否付费
	boolean isConsumption(int bid);
	
	//4.下载
	int download(int bid, int uid, String created, double money);

	//5.vip下载(下载付费图书)
	int vipdownload(int bid, int uid, String created, double money);
	
	//6.排行榜
	List<Book> rankingList();
	
	//7.根据图书类别id(cid)查询图书list
	List<Book> queryBookByCid(int cid, int index, int currentProducts);
	
	//8.根据图书类别id(cid)查询图书list
	int queryTotalProducts(int cid);

	// 9.根据图书名称(name)查询图书信息
	Book queryBookByName(String bookName);
	
	//10.根据图书id修改图书信息
	int updateBookInfo(int bid);
	
	//11.添加图书
	int addBook(String name, String autor, double price, String imgsrc,
				String subscript, String created);
	
	//12.向分类表内添加图书的分类信息
	int addBookCategory(int cid, String bookname) ;
	
}
