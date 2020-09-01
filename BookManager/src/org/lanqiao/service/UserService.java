package org.lanqiao.service;

import java.util.List;

import org.lanqiao.bean.User;

/*
 * 服务用户表接口
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
 * 10.充值
 * 11.成为会员
 */

public interface UserService {

	// 1.查询全部user信息:
	List<User> queryAllUser();

	// 2.根据用户id查询用户信息:
	User queryUserByUid(int uid);

	// 3.增加用户信息
	int addUser(/* int uid, */ String username, String password, String telephone, double money, String sex,
			String email, String status, String vip, int rid, int counts);

	// 4.根据id修改用户信息
	int updateUser(int uid, /* String username, */ String password, String telephone,
			/* double money, String sex, */ String email/*
														 * , String status, String vip, int rid, int counts
														 */);

	// 5.根据id删除用户信息
	int deleteUser(int uid, String status);

	// 6.根据用户名称和密码查询用户信息
	User queryUserByUserNamePassword(String username, String password);

	// 7.根据用户名查询用户信息
	User queryUserByUserName(String username);

	// 8.注册
	int registor(String username, String password, String telephone, String sex, String email, String status,
			double money, String vip, int rid, int counts);

	// 9.登录
	User login(String username, String password);

	// 10.充值
	int recharge(String username, int money, int uid, String created);

	// 11.成为会员
	int toVip(double money, int uid, String created);

	// 12.消费(充值vip和下载书籍)
	int consumption(int uid, double money);

	// 13.根据uid查询余额
	double muchMoney(int uid);

	// 14.查询所有管理员或超级管理员
	List<User> queryAllManager(int rid);

	// 15.添加管理员
	int addManager(String username, String password);

	//16.根据id修改管理员信息
	int updateManager(int uid, String password, String telephone, String email, String gendar);

	//17.根据用户名查询管理员信息
	User queryManagerByUserName(String username);
	
}
