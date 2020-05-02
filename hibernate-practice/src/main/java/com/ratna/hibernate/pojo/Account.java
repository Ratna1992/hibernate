package com.ratna.hibernate.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@EmbeddedId
	private AccountSecret loginId;
	private String branch;
	private String ifscCode;
	private double accountNumber;
	public AccountSecret getLoginId() {
		return loginId;
	}
	public void setLoginId(AccountSecret loginId) {
		this.loginId = loginId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	

}
