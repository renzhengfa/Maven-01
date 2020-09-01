package org.lanqiao.bean;

/*
 * 角色权限类
 * rid(角色id),fid(权限id)
 */

public class Role_function {
	
	private int rid;
	private int fid;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	@Override
	public String toString() {
		return "Role_function [rid=" + rid + ", fid=" + fid + "]";
	}
	
}
