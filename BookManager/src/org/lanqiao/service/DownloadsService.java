package org.lanqiao.service;


/*
 * 操作用户图书下载记录表的接口
 * 
 * 1.向表插入数据(每一条消费记录):(int addRecord(int uid,int bid,String created))
 */


public interface DownloadsService {
	
	//1.向表插入数据(每一条消费记录)
	int addRecord(int uid,int bid,String created);
	
}
