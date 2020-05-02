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
@Table(name="country")
public class Country {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@ManyToMany(mappedBy = "country")
	private Collection<State> state = new ArrayList<>();
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
	public Collection<State> getState() {
		return state;
	}
	public void setState(Collection<State> state) {
		this.state = state;
	}
	

}
