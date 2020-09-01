package org.lanqiao.bean;

/*
 * ½ÇÉ«Àà
 * rid,rname, description(ÃèÊö)
 */

public class Role {
	
	private int rid;
	private String rname;
	private String description;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", description=" + description + "]";
	}
	
}
