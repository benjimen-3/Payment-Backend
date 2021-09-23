package com.dbs.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="bank")
public class Bank {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name="bic", length=20)
	private String bic;
	
	@Column(name = "bankname")
	@NotBlank
	private String bankname;
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(String bic, String bankname) {
		super();
		this.bic = bic;
		this.bankname = bankname;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankname=" + bankname + "]";
	}
	

}
