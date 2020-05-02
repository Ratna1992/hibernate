package com.ratna.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class AccountSecret implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date accountStartDate;
	private Long mobileNumber;
	public Date getAccountStartDate() {
		return accountStartDate;
	}
	public void setAccountStartDate(Date accountStartDate) {
		this.accountStartDate = accountStartDate;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

}
