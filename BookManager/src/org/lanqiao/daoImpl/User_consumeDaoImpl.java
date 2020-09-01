package org.lanqiao.daoImpl;

import java.sql.SQLException;

/*
 * id,uid(用户id),created(时间),bid(图书id),
 * vip(1是2否),xc(1充值2消费),money
 */

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.bean.User_consume;
import org.lanqiao.dao.User_consumeDao;
import org.lanqiao.utils.JDBCUtil;

public class User_consumeDaoImpl implements User_consumeDao {

	//获取查询环境
	static QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
	
	//1.根据用户id查询单个用户的消费记录:
	@Override
	public List<User_consume> queryUser_consumeByUid(int uid) throws SQLException {
		String sql = "select * from user_consume where uid = ?";
		List<User_consume> list = runner.query(sql, new BeanListHandler<User_consume>(User_consume.class), uid);
		return list;
	}

	//2.插入消费记录:(每消费一次就会插入一条数据)
	@Override
	public int addUser_consume(int uid, String created, int bid, String vip, String xc, double money) throws SQLException {
		String sql = "insert into user_consume values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {null, uid, created, bid, vip, xc, money};
		int i = runner.update(sql, params);
		return i;
	}

	//3.查询单个用户的vip下载数量(根据用户id)
	@Override
	public int queryUserVipDownloadsCounts(int uid) throws SQLException {
		String sql = "SELECT COUNT(*) FROM user_consume WHERE bid != 0 AND vip = 1 AND uid = ?";
		Long i = runner.query(sql, new ScalarHandler<>(), uid);
		return i.intValue();
	}

	//4.统计所有用户一个月的消费总金额
	@Override
	public double sumMonthConsumption(String created) throws SQLException {
		String sql = "SELECT SUM(money) FROM user_consume WHERE xc = '2' AND created LIKE ?";
		Object object = runner.query(sql, new ScalarHandler<>(), created+"%");
		object = object == null ? 0.0 : object;
		double doubleValue = Double.parseDouble(object.toString());
		return doubleValue;
	}
	
	//5.统计所有用户一个月的充值总金额
	@Override
	public double sumMonthRecharge(String created) throws SQLException {
		String sql = "SELECT SUM(money) FROM user_consume WHERE xc = '1' AND created LIKE ?";
		Object object = runner.query(sql, new ScalarHandler<>(), created+"%");
		object = object == null ? 0.0 : object;
		double doubleValue = Double.parseDouble(object.toString());
		return doubleValue;
	}
	
	//6.统计所有用户的消费总金额
		@Override
		public double sumConsumption() throws SQLException {
			String sql = "SELECT SUM(money) FROM user_consume WHERE xc = '2'";
			Object object = runner.query(sql, new ScalarHandler<>());
			double doubleValue = Double.parseDouble(object.toString());
			return doubleValue;
		}
		
		//7.统计所有用户的充值总金额
		@Override
		public double sumRecharge() throws SQLException {
			String sql = "SELECT SUM(money) FROM user_consume WHERE xc = '1'";
			Object object = runner.query(sql, new ScalarHandler<>());
			double doubleValue = Double.parseDouble(object.toString());
			return doubleValue;
		}
	
}
