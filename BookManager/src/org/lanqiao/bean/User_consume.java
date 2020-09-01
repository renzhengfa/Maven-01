package org.lanqiao.bean;

/*
 * 用户消费类
 * id,uid(用户id),created(时间),
 * bid(图书id),vip(1是2否),xc(1充值2消费),money
 */

public class User_consume {
	
	private int id;
	private int uid;
	private String created;
	private int bid;
	private String vip;
	private String xc;
	private double money;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getXc() {
		return xc;
	}
	public void setXc(String xc) {
		this.xc = xc;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "UserConsume [id=" + id + ", uid=" + uid + ", created=" + created + ", bid=" + bid + ", vip=" + vip
				+ ", xc=" + xc + ", money=" + money + "]";
	}
	
}
