package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 创建连接数据库的工具类
 */

public class JDBCUtil {
	
	//获取数据源
	static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	//获得单个连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//获得数据源
	public static DataSource getDataSource() {
		return ds;
	}
	
}
