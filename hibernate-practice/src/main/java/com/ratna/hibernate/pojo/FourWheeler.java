package com.ratna.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="four_wheeler")
public class FourWheeler extends Vehicle{
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
		return "FourWheeler [controlType=" + controlType + ", price=" + price + "]";
	}
}
