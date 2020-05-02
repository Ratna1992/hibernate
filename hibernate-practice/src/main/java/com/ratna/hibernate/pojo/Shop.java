package com.ratna.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	@Id
	@GeneratedValue
	private int shopId;
	private String city;
	private String name;
	private float revenue;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRevenue() {
		return revenue;
	}
	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", city=" + city + ", name=" + name + ", revenue=" + revenue + "]";
	}
	

}
