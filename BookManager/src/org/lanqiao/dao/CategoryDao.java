package org.lanqiao.dao;

import java.sql.SQLException;

/*
 * 操作图书分类接口
 * cid,cname
 * 1.根据分类cname查询所属id(int queryCidByCname(String cname))
 * 2.查询全部分类信息(...)
 * 3.根据cid查询cname
 */

public interface CategoryDao {
	
	//1.根据分类cname查询所属id;
	int queryCidByCname(String cname) throws SQLException;
	
	//3.根据cid查询cname
	String queryCnameByCid(int cid) throws SQLException;
	
}
