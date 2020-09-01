package org.lanqiao.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.User;
import org.lanqiao.dao.UserDao;
import org.lanqiao.daoImpl.UserDaoImpl;
import org.lanqiao.service.UserService;

/**
 * 服务用户表类
 * uid,username,password,telephone,sex,email,
 * status(1正常使用2已作废),money(金额),vip(1是2否), 
 * rid,counts(下载次数)
 * 
 * 1.查询全部user信息:(List<User> queryAllUser())
 * 2.根据用户id查询用户信息:(User queryUserByUid(int uid))
 * 3.增加用户信息
 * 4.根据id修改用户信息
 * 5.根据id删除用户信息
 * 6.根据用户名称和密码查询用户信息
 * 7.根据用户名查询用户信息
 * 8.注册
 * 9.登录
 */

public class UserServiceImpl implements UserService {

	//创建DaoImpl层需要的对象
	UserDao userDao = new UserDaoImpl();
	
	// 1.查询全部user信息:
	@Override
	public List<User> queryAllUser() {
		List<User> list = null;
		try {
			list = userDao.queryAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.根据用户id查询用户信息:
	@Override
	public User queryUserByUid(int uid) {
		User user = null;
		try {
			user = userDao.queryUserByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// 3.增加用户信息
	@Override
	public int addUser(String username, String password, String telephone, 
			double money, String sex, String email,
			String status, String vip, int rid, int counts) {
		int i = 0;
		try {
			i = userDao.addUser( username, password, telephone, sex, email, status, money, vip, rid, counts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 4.根据id修改用户信息
	@Override
	public int updateUser(int uid, String password, String telephone, String email) {
		int i = 0;
		try {
			i = userDao.updateUser(uid, password, telephone, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 5.根据uid删除用户信息
	@Override
	public int deleteUser(int uid, String status) {
		int i = 0;
		try {
			i = userDao.deleteUser(uid, status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//6.根据用户名称和密码查询用户信息
	@Override
	public User queryUserByUserNamePassword(String username, String password) {
		User user = null;
		try {
			user = userDao.queryUserByUserNamePassword(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	//7.根据用户名查询用户信息
	@Override
	public User queryUserByUserName(String username) {
		User user = null;
		try {
			user = userDao.queryUserByUserName(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	//8.注册
	@Override
	public int registor(String username, String password, String telephone, String sex, String email,
			 String status, double money,
			 String vip, int rid, int counts) {
		int i = 0;
		try {
			i = userDao.registor( username, password, telephone, sex, email, status, money, vip, rid, counts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//9.登录
	@Override
	public User login(String username, String password) {
		User user = null;
		try {
			user = userDao.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	//10.充值
	@Override
	public int recharge(String username, int money, int uid, String created) {
		int i = 0;
		try {
			i = userDao.recharge(username, money, uid, created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//11.成为会员
	@Override
	public int toVip(double money, int uid, String created) {
		int i = 0;
		try {
			i = userDao.toVip(money, uid, created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//12.消费(充值vip和下载书籍)
	@Override
	public int consumption(int uid, double money) {
		int i = 0;
		try {
			i = userDao.consumption(uid, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//13.根据用户id查询用户余额
	@Override
	public double muchMoney(int uid) {
		double i = 0.0;
		try {
			i = userDao.muchMoney(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	//14.查询所有管理员或超级管理员
	@Override
	public List<User> queryAllManager(int rid) {
		List<User> list = null;
		try {
			list = userDao.queryAllManager(rid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 15.添加管理员
	@Override
	public int addManager(String username, String password) {
		int i = 0;
		try {
			i = userDao.addManager(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//16.根据id修改管理员信息
	@Override
	public int updateManager(int uid, String password, String telephone, String email, String gendar) {
		int i = 0;
		try {
			i = userDao.updateManager(uid, password, telephone, email, gendar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//17.根据用户名查询管理员信息
	@Override
	public User queryManagerByUserName(String username) {
		User user = null;
		try {
			user = userDao.queryManagerByUserName(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
