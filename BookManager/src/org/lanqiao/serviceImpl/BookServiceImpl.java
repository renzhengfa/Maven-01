package org.lanqiao.serviceImpl;

/*
 * 服务图书表的类
 * 
 * 1.调用daoImpl层方法查询全部图书:(queryAllBook())
 * 2.调用daoImpl层方法根据图书id查询单个图书:(queryBookById(int id))
 */

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.Book;
import org.lanqiao.dao.BookDao;
import org.lanqiao.daoImpl.BookDaoImpl;
import org.lanqiao.service.BookService;

public class BookServiceImpl implements BookService {

	// 创建DaoImpl层需要的对象
	BookDao bookDao = new BookDaoImpl();

	// 1.调用daoImpl层方法查询全部图书:
	@Override
	public List<Book> queryAllBook() {
		List<Book> list = null;
		try {
			list = bookDao.queryAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.调用daoImpl层方法根据图书id查询单个图书:
	@Override
	public Book queryBookById(int id) {
		Book book = null;
		try {
			book = bookDao.queryBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	// 3.根据图书id查询图书是否付费
	@Override
	public boolean isConsumption(int bid) {
		boolean isConsumption = false;
		try {
			isConsumption = bookDao.isConsumption(bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isConsumption;
	}

	// 4.下载
	@Override
	public int download(int bid, int uid, String created, double money) {
		int i = 0;
		try {
			i = bookDao.download(bid, uid, created, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 5.VIP下载
	@Override
	public int vipdownload(int bid, int uid, String created, double money) {
		int i = 0;
		try {
			i = bookDao.vipdownload(bid, uid, created, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 6.排行榜
	@Override
	public List<Book> rankingList() {
		List<Book> list = null;
		try {
			list = bookDao.rankingList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 7.根据图书类别id(cid)查询图书list
	@Override
	public List<Book> queryBookByCid(int cid, int index, int currentProducts) {
		List<Book> list = null;
		try {
			list = bookDao.queryBookByCid(cid, index, currentProducts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 8.根据图书类别id(cid)查询图书list
	@Override
	public int queryTotalProducts(int cid) {
		int i = 0;
		try {
			i = bookDao.queryTotalProducts(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 9.根据图书名称(name)查询图书信息
	@Override
	public Book queryBookByName(String bookName) {
		Book book = null;
		try {
			book = bookDao.queryBookByName(bookName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	//10.根据图书id修改图书信息
	@Override
	public int updateBookInfo(int bid) {
		int i = 0;
		try {
			i = bookDao.updateBookInfo(bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//11.添加图书
	@Override
	public int addBook(String name, String autor, double price, String imgsrc, 
			String subscript, String created) {
		int i = 0;
		try {
			i = bookDao.addBook(name, autor, price, imgsrc, subscript, created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//12.向分类表内添加图书的分类信息(需要先添加图书才能根据图书名称查询图书id)
	@Override
	public int addBookCategory(int cid, String bookname) {
		int i = 0;
		try {
			i = bookDao.addBookCategory(cid, bookname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
