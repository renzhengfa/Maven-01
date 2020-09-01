package org.lanqiao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.lanqiao.utils.JDBCUtil;

public class JDBCTest {

	public static void main(String[] args) {
		//获取连接
		Connection conn = JDBCUtil.getConnection();
//		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		QueryRunner runner = new QueryRunner();
		try {
			List<Map<String, Object>> query = runner.query(conn, "select * from user", new MapListHandler());
			//遍历打印
			for (Map<String, Object> map : query) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
