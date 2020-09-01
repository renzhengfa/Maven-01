package org.lanqiao.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.bean.Book;
import org.lanqiao.dao.PageBeanDao;
import org.lanqiao.utils.JDBCUtil;

public class PageBeanDaoImpl implements PageBeanDao {

	//获取查询环境
	static QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
	
	//1.根据当前页查询当前页的图书信息(默认一页为10本书)
	@Override
	public List<Book> queryBookByCurrentPageIndex(int curentPageIndex,int currentPageProducts) throws SQLException {
		String sql = "select * from book LIMIT ?, ?";//如果第一页就0开始查询,后面就[((索引减1)*10)-1]开始查询
		Object[] params = {curentPageIndex == 1 ? 0 : 10*(curentPageIndex - 1), currentPageProducts};
		List<Book> list = runner.query(sql, new BeanListHandler<Book>(Book.class), params);
		return list;
	}

	//2.查询所有图书本书:
	@Override
	public int countBook() throws SQLException {
		String sql = "select count(*) from book";
		Long i = (Long)runner.query(sql, new ScalarHandler<>());
		return i.intValue();
	}

}
