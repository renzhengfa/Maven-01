package org.lanqiao.dao;

import java.sql.SQLException;

/*
 * 操作用户图书下载记录表的接口
 * did,uid(用户id),bid(图书id), created(下载时间)
 * 
 * 1.向表插入数据(每一条消费记录):(int addRecord(int uid,int bid,String created))
 */

public interface DownloadsDao {
	
	//1.向表插入数据(每一条消费记录)
	int addRecord(int uid,int bid,String created) throws SQLException;
	
}
