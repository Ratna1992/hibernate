package com.ratna.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "state")
public class State {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@ManyToMany
	private Collection<Country> country = new ArrayList<>();
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
	public Collection<Country> getCountry() {
		return country;
	}
	public void setCountry(Collection<Country> country) {
		this.country = country;
	}
	

}
