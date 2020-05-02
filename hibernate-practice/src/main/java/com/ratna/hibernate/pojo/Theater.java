package com.ratna.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="theater")
public class Theater {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@OneToOne
	@JoinColumn(name="theatre_audience_id")
	private Audience audience;
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
	public Audience getAudience() {
		return audience;
	}
	public void setAudience(Audience audience) {
		this.audience = audience;
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", audience=" + audience + "]";
	}

	
}
