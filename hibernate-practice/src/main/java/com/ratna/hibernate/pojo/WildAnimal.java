package com.ratna.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="wild_animal")
public class WildAnimal extends Animal {

	private int weight;
	private String color;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "WildAnimal [weight=" + weight + ", color=" + color + "]";
	}
	
	
}
