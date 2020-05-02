package com.ratna.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Long mobile;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@ElementCollection
	@JoinTable(name = "client_address", joinColumns = @JoinColumn(name = "client_id"))
	@GenericGenerator(name = "increment", strategy = "increment")
	@CollectionId(columns = @Column(name = "address_id"), generator = "increment", type = @Type(type = "long"))
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
