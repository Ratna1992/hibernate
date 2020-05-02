package com.ratna.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue
	private Integer pid;
	@Column
	private String disease;
	@Column
	private String pname;
	@OneToOne(targetEntity = Employee.class)
	private Doctor doctor;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", disease=" + disease + ", pname=" + pname + ", doctor=" + doctor + "]";
	}
	
	
	
	

}
