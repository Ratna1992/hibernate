package com.ratna.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String mno;
	@OneToMany
	@JoinTable(name = "owner_rent_house", joinColumns = @JoinColumn(name = "owner_id"), inverseJoinColumns = @JoinColumn(name = "house_id"))
	private Collection<RentHouse> rentHouse = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public Collection<RentHouse> getRentHouse() {
		return rentHouse;
	}

	public void setRentHouse(Collection<RentHouse> rentHouse) {
		this.rentHouse = rentHouse;
	}

}
