package com.ratna.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="two_wheeler")
public class TwoWheeler extends Vehicle{
	
	private String controlType;
	private float price;
	public String getControlType() {
		return controlType;
	}
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "TwoWheeler [controlType=" + controlType + ", price=" + price + "]";
	}
	

}
