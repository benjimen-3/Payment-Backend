package com.dbs.web.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.dbs.web.utils.TransferType;



@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Transaction_id", length = 20)
	private int transactionid;
	
	@ManyToOne()
	@JoinColumn(name="customerid")
	@NotNull
	private Customer customer;
	
	private String currencycode;
	private String senderBIC;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="receiverBIC", referencedColumnName = "bic")
	@NotNull
	private Bank receiverBIC;
	
	@Column(name="receiver_number")
	@NotBlank
	private String receiveraccountholdernumber;
	
	@Column(name="receiver_name")
	@NotBlank
	private String receiveraccountholdername;
	
	@Column(name="tranfer_type", length=10)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TransferType transfertypecode;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="message_code")
	@NotNull
	private Message messagecode;
	private double currencyamount;
	private double transferfees;
	
	@Column(name="amount")
	@Positive
	@NotNull
	private double inramount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date transferdate;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionid, @NotNull Customer customer, String currencycode, String senderBIC,
			@NotNull @NotNull Bank receiverBIC, @NotBlank String receiveraccountholdernumber,
			@NotBlank String receiveraccountholdername, @NotNull TransferType transfertypecode,
			@NotNull Message messagecode, double currencyamount, double transferfees,
			@Positive @NotNull double inramount, @NotNull Date transferdate) {
		super();
		this.transactionid = transactionid;
		this.customer = customer;
		this.currencycode = currencycode;
		this.senderBIC = senderBIC;
		this.receiverBIC = receiverBIC;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.transfertypecode = transfertypecode;
		this.messagecode = messagecode;
		this.currencyamount = currencyamount;
		this.transferfees = transferfees;
		this.inramount = inramount;
		this.transferdate = transferdate;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public String getSenderBIC() {
		return senderBIC;
	}
	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}
	public Bank getReceiverBIC() {
		return receiverBIC;
	}
	public void setReceiverBIC(Bank receiverBIC) {
		this.receiverBIC = receiverBIC;
	}
	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}
	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}
	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}
	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}
	public TransferType getTransfertypecode() {
		return transfertypecode;
	}
	public void setTransfertypecode(TransferType transfertypecode) {
		this.transfertypecode = transfertypecode;
	}
	public Message getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(Message messagecode) {
		this.messagecode = messagecode;
	}
	public double getCurrencyamount() {
		return currencyamount;
	}
	public void setCurrencyamount(double currencyamount) {
		this.currencyamount = currencyamount;
	}
	public double getTransferfees() {
		return transferfees;
	}
	public void setTransferfees(double transferfees) {
		this.transferfees = transferfees;
	}
	public double getInramount() {
		return inramount;
	}
	public void setInramount(double inramount) {
		this.inramount = inramount;
	}
	public Date getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customer=" + customer + ", currencycode="
				+ currencycode + ", senderBIC=" + senderBIC + ", receiverBIC=" + receiverBIC
				+ ", receiveraccountholdernumber=" + receiveraccountholdernumber + ", receiveraccountholdername="
				+ receiveraccountholdername + ", transfertypecode=" + transfertypecode + ", messagecode=" + messagecode
				+ ", currencyamount=" + currencyamount + ", transferfees=" + transferfees + ", inramount=" + inramount
				+ ", transferdate=" + transferdate + "]";
	}
	
}
