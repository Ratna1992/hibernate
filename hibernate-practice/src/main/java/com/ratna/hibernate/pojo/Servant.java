package com.ratna.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servant")
public class Servant {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Long mobile;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "customer_address", joinColumns = @JoinColumn(name = "customer_id"))
	private Collection<Address> address = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Collection<Address> getAddress() {
		return address;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	
}
