/*
package com.kn.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

*/
/*
 * �����������ݿ�Ĺ�����
 *//*


public class JDBCUtil {
	
	//��ȡ����Դ
	static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	//��õ�������
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//�������Դ
	public static DataSource getDataSource() {
		return ds;
	}
	
}
*/
