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
@Table(name="crew")
public class Crew {
	@Id
	@GeneratedValue
	private int crewId;
	@Column
	private String name;
	@ManyToMany
	private Collection<Supervisor> supervisor = new ArrayList<>();
	public int getCrewId() {
		return crewId;
	}
	public void setCrewId(int crewId) {
		this.crewId = crewId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Supervisor> getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Collection<Supervisor> supervisor) {
		this.supervisor = supervisor;
	}
	
	

}
