package org.lanqiao.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.lanqiao.bean.User_consume;
import org.lanqiao.dao.User_consumeDao;
import org.lanqiao.daoImpl.User_consumeDaoImpl;
import org.lanqiao.service.User_consumeService;

/*
 * 服务用户消费表user_consume的类
 * id,uid(用户id),created(时间),bid(图书id),
 * vip(1是2否),xc(1充值2消费),money
 * 
 * 1.根据用户id查询单个用户的消费记录:(List<User_consume> queryUser_consumeByUid(int uid))
 * 2.插入消费记录:(int addUser_consume(int uid,String created,int bid,String vip,String xc,double money))
 */

public class User_consumeServiceImpl implements User_consumeService {

	//创建DaoImpl层需要的对象
	User_consumeDao user_consumeDao = new User_consumeDaoImpl();
	
	//1.根据用户id查询单个用户的消费记录:
	@Override
	public List<User_consume> queryUser_consumeByUid(int uid) {
		List<User_consume> list = null;
		try {
			list = user_consumeDao.queryUser_consumeByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//2.插入消费记录:
	@Override
	public int addUser_consume(int uid, String created, int bid, String vip, String xc, double money) {
		int i = 0;
		try {
			i = user_consumeDao.addUser_consume(uid, created, bid, vip, xc, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//3.查询单个用户的vip下载数量(根据用户id)
	@Override
	public int queryUserVipDownloadsCounts(int uid) {
		int i = 0;
		try {
			i = user_consumeDao.queryUserVipDownloadsCounts(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//4.统计所有用户一个月的消费总金额
	@Override
	public double sumMonthConsumption(String created) {
		double sum = 0;
		try {
			sum = user_consumeDao.sumMonthConsumption(created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	//5.统计所有用户一个月的充值总金额
	@Override
	public double sumMonthRecharge(String created) {
		double sum = 0;
		try {
			sum = user_consumeDao.sumMonthRecharge(created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
		
	//6.统计所有用户的消费总金额
	@Override
	public double sumConsumption() {
		double sum = 0;
		try {
			sum = user_consumeDao.sumConsumption();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	//7.统计所有用户的充值总金额
	@Override
	public double sumRecharge() {
		double sum = 0;
		try {
			sum = user_consumeDao.sumRecharge();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

}
