package org.lanqiao.bean;

/*
 * 用户信息类:
 * uid,username,password,telephone,sex,email,
 * status(1正常使用2已作废),money(金额),vip(1是2否),
 * rid,counts(下载次数)
 */

public class User {

	private int uid;
	private String username;
	private String password;
	private String telephone;
	private String sex;
	private String email;
	private String status;
	private double money;
	private String vip;
	private int rid;
	private int counts;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", telephone=" + telephone
				+ ", sex=" + sex + ", email=" + email + ", status=" + status + ", money=" + money + ", vip=" + vip
				+ ", rid=" + rid + ", counts=" + counts + "]";
	}
	
}
