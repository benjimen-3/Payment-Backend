package com.dbs.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.dbs.web.utils.OverDraft;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerid", length = 20)
	private String customerid;
	
	@Column(name="accountholdername")
	@NotBlank
	private String accountholdername;
	
	@Column(name="overdraft", length=4)
	@Enumerated(EnumType.STRING)
	@NotNull
	OverDraft  overdraftflag;
	
	@Column(name="clearbalance")
	@NotNull
	private double clearbalance;
	
	private String customeraddress;
	@Column(name="customercity")
	private String city;
	private char customertype;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerid, String accountholdername, OverDraft overdraftflag, double clearbalance,
			String customeraddress, String city, char customertype) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraftflag = overdraftflag;
		this.clearbalance = clearbalance;
		this.customeraddress = customeraddress;
		this.city = city;
		this.customertype = customertype;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public OverDraft getOverdraftflag() {
		return overdraftflag;
	}
	public void setOverdraftflag(OverDraft overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	public double getClearbalance() {
		return clearbalance;
	}
	public void setClearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public char getCustomertype() {
		return customertype;
	}
	public void setCustomertype(char customertype) {
		this.customertype = customertype;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraftflag="
				+ overdraftflag + ", clearbalance=" + clearbalance + ", customeraddress=" + customeraddress + ", city="
				+ city + ", customertype=" + customertype + "]";
	}
	

}
