package com.ratna.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="state_name")
	private String state;
	@Column(name="city_name")
	private String city;
	@Column(name="street_name")
	private String street;
	@Column(name="pin_code")
	private Integer pin;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + ", pin=" + pin + "]";
	}
	
	

}
