package org.lanqiao.dao;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.Book;

/*
 * 操作图书表的接口
 * 
 * bid,name,author(作者),price(价格),image(图片),content(简介),
 * status(1-正常，2-下架) , counts(下载量) ,created(时间)
 * 
 * 1.查询全部图书:(queryAllBook())
 * 2.根据图书id查询单个图书:(queryBookById(int id))
 * 3.根据图书id查询图书所属类别(付费与否)
 * 4.下载
 * 5.VIP下载
 * 6.排行榜
 * 7.根据图书类别id(cid)查询当前页图书list
 * 8.根据图书类别id(cid)查询图书list
 */

public interface BookDao {
	
	//1.查询全部图书:(queryAllBook())
	List<Book> queryAllBook() throws SQLException;
	
	//2.根据图书id查询单个图书:(queryBookById(int id))
	Book queryBookById(int bid) throws SQLException;
	
	//3.根据图书id查询图书所属类别(付费与否)
	boolean isConsumption(int bid) throws SQLException;
	
	//4.下载
	int download(int bid, int uid, String created, double money) throws SQLException;

	//5.VIP下载
	int vipdownload(int bid, int uid, String created, double money) throws SQLException;
	
	//6.排行榜
	List<Book> rankingList() throws SQLException;
	
	//7.根据图书类别cid(cid)查询当前页图书list
	List<Book> queryBookByCid(int cid, int index, int currentProducts) throws SQLException;
	
	//8.根据图书类别cid(cid)查询图书list
	int queryTotalProducts(int cid) throws SQLException;

	//9.根据图书名称查询图书信息
	Book queryBookByName(String bookName) throws SQLException;
	
	//10.根据图书id修改图书信息
	int updateBookInfo(int bid) throws SQLException;
	
	//11.添加图书
	int addBook(String name, String autor, double price, String imgsrc,
			String subscript, String created) throws SQLException;
	
	//12.向分类表内添加图书的分类信息
	int addBookCategory(int cid, String bookname) throws SQLException;
	
}
