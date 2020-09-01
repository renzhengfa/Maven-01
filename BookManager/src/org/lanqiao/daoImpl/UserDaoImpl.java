package org.lanqiao.daoImpl;

/*
 * uid,username,password,telephone,sex,email,
 * status(1正常使用2已作废),money(金额),vip(1是2否), 
 * rid,counts(下载次数)
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.bean.User;
import org.lanqiao.dao.UserDao;
import org.lanqiao.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {
	
	//发现执行sql的环境
	static QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

	//1.查询全部user信息:
	@Override
	public List<User> queryAllUser() throws SQLException {
		String sql = "select * from user";
		List<User> list = runner.query(sql, new BeanListHandler<User>(User.class));
		return list;
	}

	//2.根据用户id查询用户信息:
	@Override
	public User queryUserByUid(int uid) throws SQLException {
		String sql = "select * from user where uid = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), uid);
		return user;
	}

	//3.增加用户信息
	@Override
	public int addUser(String username, String password, String telephone, String sex, String email,
			 String status, double money,
			 String vip, int rid, int counts) throws SQLException {
		String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {null, username, password, telephone, sex, email, status, money, vip, rid, counts};
		int i = runner.update(sql, params);
		return i;
	}

	//4.根据id修改用户信息
	@Override
	public int updateUser(int uid, String password, String telephone, String email) throws SQLException {
		String sql = "update user set password = ?, telephone = ?, email = ? where uid = ?";
		Object[] params = {password, telephone, email, uid};
		int i = runner.update(sql, params);
		return i;
	}

	//5.根据id"删除"用户信息
	@Override
	public int deleteUser(int uid, String status) throws SQLException {
		String sql = "update user set status = ? where uid = ?";
		int i = runner.update(sql, status, uid);
		return i;
	}


	//6.根据用户名称和密码查询用户信息
	@Override
	public User queryUserByUserNamePassword(String username, String password) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<User>(User.class), username, password);
	}

	//7.根据用户名查询用户信息
	@Override
	public User queryUserByUserName(String username) throws SQLException {
		String sql = "select * from user where username = ?";
		return runner.query(sql, new BeanHandler<User>(User.class), username);
	}

	//8.注册
	@Override
	public int registor(String username, String password, String telephone, String sex, String email,
			 String status, double money,
			 String vip, int rid, int counts) throws SQLException {
		//先根据用户名查询是否有这个人
		String sql = "select * from user where username = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), username);
		int i = 0;
		if(user == null) {
			i = addUser(username, password, telephone, sex, email, status, money, vip, rid, counts);
		}
		return i;
	}

	//9.登录
	@Override
	public User login(String username, String password) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<User>(User.class), username, password);
	}
	
	//10.充值
	@Override
	public int recharge(String username, int money, int uid, String created) throws SQLException {
		String sql = "update user set money = money + ? where username = ?";
		int i = runner.update(sql, money , username);
		//向消费记录表插入数据(0代表不是买书,没有bid=0)(2代表普通用户)("1"代表充值)
		String sql1 = "insert into user_consume values(?,?,?,?,?,?,?)";
		Object[] params = {null, uid, created, 0, 2, "1", money};
		int j = runner.update(sql1, params);
		if(i != 0 && j != 0) {
			return i;
		}
		return 0;
	}

	//11.成为会员
	@Override
	public int toVip(double money, int uid, String created) throws SQLException {
		//1.改变user表内vip的状态值
		String sql = "update user set vip = ? where uid = ?";
		int i = runner.update(sql, 1 , uid);
		//2.添加消费记录
		String sql1 = "insert into user_consume values(?,?,?,?,?,?,?)";
		Object[] params = {null, uid, created, 0, 1, "2", money};
		int j = runner.update(sql1, params);
		if(i != 0 && j != 0) {
			return i;
		}
		return 0;
	}

	//12.消费(充值vip和下载书籍)
	@Override
	public int consumption(int uid, double money) throws SQLException {
		String sql = "update user set money = money - ? where uid = ?";
		return runner.update(sql, money , uid);
	}

	//13.查询用户余额
	@Override
	public double muchMoney(int uid) throws SQLException {
		String sql = "select money from user where uid = ?";
		double i = runner.query(sql, new ScalarHandler<>(), uid);
		return i;
	}

	//14.查询所有管理员或超级管理员
	@Override
	public List<User> queryAllManager(int rid) throws SQLException {
		String sql = "select * from user where rid = ?";
		List<User> list = runner.query(sql, new BeanListHandler<User>(User.class), rid);
		return list;
	}

	//15.添加管理员
	@Override
	public int addManager(String username, String password) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {null, username, password, null, null, null, "1", 0, 2, 3, 0};
		int i = runner.update(sql, params);
		return i;
	}

	//16.根据id修改管理员信息
	@Override
	public int updateManager(int uid, String password, String telephone, String gendar, String email) throws SQLException {
		String sql = "UPDATE USER SET PASSWORD = ?, telephone = ?, email = ?, sex = ? WHERE uid = ?";
		Object[] params = {password, telephone, gendar, email, uid};
		int i = runner.update(sql, params);
		return i;
	}
	

	//17.根据用户名查询管理员信息
	@Override
	public User queryManagerByUserName(String username) throws SQLException {
		String sql = "select * from user where username = ? and rid = 3";
		return runner.query(sql, new BeanHandler<User>(User.class), username);
	}
	
}
