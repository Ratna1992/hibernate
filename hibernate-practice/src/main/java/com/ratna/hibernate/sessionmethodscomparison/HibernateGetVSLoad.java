package com.ratna.hibernate.sessionmethodscomparison;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Audience;

public class HibernateGetVSLoad {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Audience load = session.load(Audience.class, 226);
		// don't hit database every time and hence doesn't fire a query
		// if u use the object it fires a query
		// gives proxy object
		// if no record return exception
		System.out.println(load);

		Audience audience = session.get(Audience.class, 171);
		// get every time hits database and hence fires a query
		// if u use or not object hits query
		// gives real object
		// if no record returns null
		System.out.println(audience);

		session.getTransaction().commit();

	}

}
