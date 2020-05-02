package com.ratna.hibernate.relationalmapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Owner;
import com.ratna.hibernate.pojo.RentHouse;

public class HibernateOTMAndMTOMappingWithJoinTable {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		RentHouse house1 = new RentHouse();
		house1.setAddress("Pamarru krishna district d no 16-143 Annapurna Nilayam");

		RentHouse house2 = new RentHouse();
		house2.setAddress("Pamarru krishna district d no 16-144 Laxmi Nilayam");

		Owner owner = new Owner();
		owner.setMno("8499899121");
		owner.setName("Ratna");
		Collection<RentHouse> rentHouse = owner.getRentHouse();
		rentHouse.add(house1);
		rentHouse.add(house2);
		owner.setRentHouse(rentHouse);
		house1.setOwner(owner);
		house2.setOwner(owner);
		session.save(owner);
		session.save(house1);
		session.save(house2);
		session.getTransaction().commit();

		
	}

}
