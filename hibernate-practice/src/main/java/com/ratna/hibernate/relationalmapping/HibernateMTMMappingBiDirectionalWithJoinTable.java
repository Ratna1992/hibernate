package com.ratna.hibernate.relationalmapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Country;
import com.ratna.hibernate.pojo.State;

public class HibernateMTMMappingBiDirectionalWithJoinTable {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		State s1 = new State();
		s1.setName("Andhra Pradesh");

		State s2 = new State();
		s2.setName("Telangana");

		State s3 = new State();
		s3.setName("Kerala");

		Country c1 = new Country();
		c1.setName("India");

		Country c2 = new Country();
		c2.setName("Bharat");

		Collection<Country> country1 = s1.getCountry();
		country1.add(c1);
		country1.add(c2);

		Collection<Country> country2 = s2.getCountry();
		country2.add(c2);
		country2.add(c1);

		Collection<Country> country3 = s3.getCountry();
		country3.add(c2);
		country3.add(c1);

		Collection<State> state1 = c1.getState();
		state1.add(s1);
		state1.add(s2);

		Collection<State> state2 = c2.getState();
		state2.add(s3);
		state2.add(s2);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(c1);
		session.save(c2);

		session.getTransaction().commit();
	}

}
