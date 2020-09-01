package org.lanqiao.serviceImpl;

/*
 * 服务图书分类表的类
 * 
 * 1.根据分类cname查询所属id(int queryCidByCname(String cname))
 * 2.查询全部分类信息(...)
 */

import java.sql.SQLException;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.daoImpl.CategoryDaoImpl;
import org.lanqiao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	//创建DaoImpl层需要的对象
	CategoryDao categoryDao = new CategoryDaoImpl();
	
	//1.根据分类cname查询所属id
	@Override
	public int queryCidByCname(String cname) {
		int i = 0;
		try {
			i = categoryDao.queryCidByCname(cname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//3.根据cid查询cname
	@Override
	public String queryCnameByCid(int cid) {
		String cname = null;
		try {
			cname = categoryDao.queryCnameByCid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cname;
	}

}
