package com.ratna.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Laptop;

public class HibernateLifeCycle {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// transient state
		Laptop l = new Laptop();
		l.setBrand("Sony");
		l.setPrice(434567d);

		// persistent state
		session.save(l);
		l.setPrice(45000d);
		l.setPrice(95000d);// last one will update

		session.getTransaction().commit();
		// detach state
		session.detach(l);
		l.setPrice(30000d);
		session.close();
		l.setPrice(50000d);

	}

}
