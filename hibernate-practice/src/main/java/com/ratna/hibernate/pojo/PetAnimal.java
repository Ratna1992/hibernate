package com.ratna.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pet_animal")
public class PetAnimal extends Animal{
	
	private float cost;  
	  
	private String breed;

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "PetAnimal [cost=" + cost + ", breed=" + breed + "]";
	} 
	
	

}
