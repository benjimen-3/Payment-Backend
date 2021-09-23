package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logger {
	@Id
	private int loggerid;
	private String customerid;
	private int userid;
	private int employeeid;
	private String screenname;
	private String action;
	private String ipaddress;
	public Logger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logger(int loggerid, String customerid, int userid, int employeeid, String screenname, String action,
			String ipaddress) {
		super();
		this.loggerid = loggerid;
		this.customerid = customerid;
		this.userid = userid;
		this.employeeid = employeeid;
		this.screenname = screenname;
		this.action = action;
		this.ipaddress = ipaddress;
	}
	public int getLoggerid() {
		return loggerid;
	}
	public void setLoggerid(int loggerid) {
		this.loggerid = loggerid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	@Override
	public String toString() {
		return "Logger [loggerid=" + loggerid + ", customerid=" + customerid + ", userid=" + userid + ", employeeid="
				+ employeeid + ", screenname=" + screenname + ", action=" + action + ", ipaddress=" + ipaddress + "]";
	}
	

}
