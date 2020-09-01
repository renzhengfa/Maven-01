package org.lanqiao.service;

import java.util.List;

import org.lanqiao.bean.User_consume;

/*
 * 服务用户消费表user_consume的接口
 * id,uid(用户id),created(时间),bid(图书id),
 * vip(1是2否),xc(1充值2消费),money
 * 
 * 1.根据用户id查询单个用户的消费记录:(List<User_consume> queryUser_consumeByUid(int uid))
 * 2.插入消费记录:(int addUser_consume(int uid,String created,int bid,String vip,String xc,double money))
 * //3.查询单个用户的vip下载数量(根据用户id)
 * //4.查询一个月的用户消费情况
 */

public interface User_consumeService {

	// 1.根据用户id查询单个用户的消费记录:
	List<User_consume> queryUser_consumeByUid(int uid);

	// 2.插入消费记录:
	int addUser_consume(int uid, String created, int bid, String vip, String xc, double money);

	//3.查询单个用户的vip下载数量(根据用户id)
	int queryUserVipDownloadsCounts(int uid);
	
	//4.统计所有用户一个月的消费总金额
	double sumMonthConsumption(String created) ;
	
	//5.统计所有用户一个月的充值总金额
	double sumMonthRecharge(String created);
	
	//6.统计所有用户的消费总金额
	double sumConsumption() ;
		
	//7.统计所有用户的充值总金额
	double sumRecharge() ;
	
}
