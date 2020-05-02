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
@Table(name = "supervisor")
public class Supervisor {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String experience;
	@ManyToMany
	private Collection<Crew> crew = new ArrayList<Crew>();
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Collection<Crew> getCrew() {
		return crew;
	}
	public void setCrew(Collection<Crew> crew) {
		this.crew = crew;
	}
	
	

}
