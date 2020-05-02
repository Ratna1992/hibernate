package com.ratna.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Laptop;

public class DetachedToTransientState {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//persistent state
		Laptop laptop = session.get(Laptop.class, 158);
		System.out.println(laptop);
		session.getTransaction().commit();
		//detached state
		session.close();
		
		
		laptop.setBrand("Apple");
		session = sessionFactory.openSession();
		session.beginTransaction();
		//persistent state
		session.update(laptop);
		
		session.getTransaction().commit();
		//detached
		session.close();

	}

}
