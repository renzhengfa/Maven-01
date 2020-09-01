package org.lanqiao.service;

/*
 * 服务图书分类接口
 * 
 * 1.根据分类cname查询所属id(int queryCidByCname(String cname))
 * 2.查询全部分类信息(...)
 */

public interface CategoryService {

	// 1.根据分类cname查询所属id;
	int queryCidByCname(String cname);

	// 3.根据cid查询cname
	String queryCnameByCid(int cid);
}
