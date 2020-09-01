package org.lanqiao.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.bean.Category;
import org.lanqiao.dao.CategoryDao;
import org.lanqiao.utils.JDBCUtil;

public class CategoryDaoImpl implements CategoryDao {

	//获取查询环境
	static QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
	
	//1.根据分类cname查询所属id
	@Override
	public int queryCidByCname(String cname) throws SQLException {
		return runner.query("select * from category where cname = ?",
				new BeanHandler<Category>(Category.class), cname).getCid();
	}

	//3.根据cid查询cname
	@Override
	public String queryCnameByCid(int cid) throws SQLException {
		String sql = "select * from category where cid = ?";
		Category category = runner.query(sql, new BeanHandler<Category>(Category.class), cid);
		return category.getCname();
	}
	
}
