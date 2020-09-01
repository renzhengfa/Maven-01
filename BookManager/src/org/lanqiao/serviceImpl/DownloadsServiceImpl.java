package org.lanqiao.serviceImpl;

import java.sql.SQLException;

import org.lanqiao.dao.DownloadsDao;
import org.lanqiao.daoImpl.DownloadsDaoImpl;
import org.lanqiao.service.DownloadsService;

/*
 * 操作用户图书下载记录表的类
 * 
 * 1.向表插入数据(每一条消费记录):(int addRecord(int uid,int bid,String created))
 */

public class DownloadsServiceImpl implements DownloadsService {

	//创建DaoImpl层需要的对象
	DownloadsDao downloadsDao = new DownloadsDaoImpl();
	
	//1.向表插入数据(每一条消费记录):
	@Override
	public int addRecord(int uid, int bid, String created) {
		int i = 0;
		try {
			i = downloadsDao.addRecord(uid, bid, created);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
