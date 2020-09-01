package org.lanqiao.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.lanqiao.bean.Book;
import org.lanqiao.dao.BookDao;
import org.lanqiao.utils.JDBCUtil;

public class BookDaoImpl implements BookDao {

	// 获取查询环境
	static QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

	// 1.查询全部图书:(queryAllBook())
	@Override
	public List<Book> queryAllBook() throws SQLException {
		return runner.query("select * from book", new BeanListHandler<Book>(Book.class));
	}

	// 2.根据图书id查询单个图书:(queryBookById(int id))
	@Override
	public Book queryBookById(int id) throws SQLException {
		return runner.query("select * from book where bid = ?", new BeanHandler<Book>(Book.class), id);
	}

	// 3.根据图书id查询图书类型(是否付费)
	@Override
	public boolean isConsumption(int bid) throws SQLException {
		String sql = "SELECT c.cname FROM category c, book_category bc, "
				+ "book b WHERE c.cid = bc.cid AND b.bid = bc.bid AND b.bid = ?";
		List<Object> list = runner.query(sql, new ColumnListHandler<>("cname"), bid);
		String cname = list.get(0).toString();
		if (cname.equals("付费")) {
			return true;
		}
		return false;
	}

	// 4.普通下载
	@Override
	public int download(int bid, int uid, String created, double money) throws SQLException {
		// 1.下载次数加1
		String sql = "update book set counts = counts + 1 where bid = ?";
		int i = runner.update(sql, bid);
		// 2.消费记录改变
		String sql1 = "insert into downloads values(?, ?, ?, ?)";
		Object[] params = { null, uid, bid, created };
		int j = runner.update(sql1, params);
		// 3.给user表的次数添加1
		String sql2 = "update user set counts = counts + 1 where uid = ?";
		int k = runner.update(sql2, uid);
		// 4.user_consume表增加消费记录
		String sql3 = "insert into user_consume values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params1 = { null, uid, created, bid, 2, 2, money };
		int l = runner.update(sql3, params1);
		if (i != 0 && j != 0 && k != 0 && l != 0) {
			return 1;
		}
		return 0;
	}

	// 5.VIP下载
	@Override
	public int vipdownload(int bid, int uid, String created, double money) throws SQLException {
		// 1.下载次数加1
		String sql = "update book set counts = counts + 1 where bid = ?";
		int i = runner.update(sql, bid);
		// 2.消费记录改变
		String sql1 = "insert into downloads values(?, ?, ?, ?)";
		Object[] params = { null, uid, bid, created };
		int j = runner.update(sql1, params);
		// 3.给user表的次数添加1
		String sql2 = "update user set counts = counts + 1 where uid = ?";
		int k = runner.update(sql2, uid);
		// 4.user_consume表增加消费记录
		String sql3 = "insert into user_consume values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params1 = { null, uid, created, bid, 1, 2, money };
		int l = runner.update(sql3, params1);
		if (i != 0 && j != 0 && k != 0 && l != 0) {
			return 1;
		}
		return 0;
	}

	// 6.排行榜(前8本书)
	@Override
	public List<Book> rankingList() throws SQLException {
		String sql = "select * from book group by counts desc limit 0,7";
		List<Book> list = runner.query(sql, new BeanListHandler<>(Book.class));
		return list;
	}

	// 7.根据图书类别id(cid)查询当前页图书list
	@Override
	public List<Book> queryBookByCid(int cid, int index, int currentProducts) throws SQLException {
		List<Book> list = null;
		String sql = "SELECT b.* FROM book b, category c, book_category bc"
				+ " WHERE b.bid = bc.bid AND c.cid = ? AND bc.cid = ? limit ?,?";
		Object[] params = { cid, cid, (index - 1) * 10, 10 };
		list = runner.query(sql, new BeanListHandler<Book>(Book.class), params);
		return list;
	}

	// 8.根据图书类别id(cid)查询图书list
	@Override
	public int queryTotalProducts(int cid) throws SQLException {
		String sql = "SELECT b.* FROM book b, category c, book_category bc"
				+ " WHERE b.bid = bc.bid AND c.cid = ? AND bc.cid = ?";
		List<Book> list = runner.query(sql, new BeanListHandler<Book>(Book.class), cid, cid);
		return list.size();
	}

	// 9.根据图书名称(name)查询图书信息
	@Override
	public Book queryBookByName(String bookName) throws SQLException {
		Book book = null;
		String sql = "select * from book where name = ?";
		book = runner.query(sql, new BeanHandler<Book>(Book.class), bookName);
		return book;
	}

	//10.根据图书id修改图书信息
	@Override
	public int updateBookInfo(int bid) throws SQLException {
		String sql = "update book set status = '2' where bid = ?";
		int i = runner.update(sql, bid);
		return i;
	}

	//11.添加图书
	@Override
	public int addBook(String name, String author, double price, String imgsrc,
			String subscript, String created)
			throws SQLException {
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {null, name, author, price, imgsrc, subscript, "1", 0, created};
		int i = runner.update(sql, params);
		return i;
	}
	
	//12.向分类表内添加图书的分类信息
	@Override
	public int addBookCategory(int cid, String bookname) throws SQLException {
		Book book = queryBookByName(bookname);
		//获取bookid
		int bid = book.getBid();
		String sql = "insert into book_category values(?,?)";
		int i = runner.update(sql, bid, cid);
		return i;
	}
}
