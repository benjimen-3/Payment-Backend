package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerUser {
	@Id
	private int userid;
	private String username;
	private String customerid;
	private String userpassword;
	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerUser(int userid, String username, String customerid, String userpassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.customerid = customerid;
		this.userpassword = userpassword;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	@Override
	public String toString() {
		return "CustomerUser [userid=" + userid + ", username=" + username + ", customerid=" + customerid
				+ ", userpassword=" + userpassword + "]";
	}
	

}
