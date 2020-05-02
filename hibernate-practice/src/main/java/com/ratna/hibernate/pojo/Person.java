package com.ratna.hibernate.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Long mobile;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "street", column = @Column(name = "home_street_name")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "pin", column = @Column(name = "home_pin_code")) })
	private Address homeAddress;
	@Embedded // not mandatory to put annotation if class is marked as embeddble
	private Address workAddress;

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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

}
