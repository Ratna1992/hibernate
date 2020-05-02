package com.ratna.hibernate.sessionmethodscomparison;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Audience;

public class HibernateMergeVSUpdate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

		// Merge: we can update the same object in two different sessions
		Session session1 = sessionFactory.openSession();
		Audience audience1 = session1.get(Audience.class, 171);
		session1.close();
		audience1.setName("Rocky");

		// session1 is closed

		Session session2 = sessionFactory.openSession();
		Audience audience2 = session2.get(Audience.class, 171);
		session2.beginTransaction();
		session2.merge(audience1);
		session2.getTransaction().commit();
		session2.close();

		// update : we can't update the same object in two different sessions
		Session session3 = sessionFactory.openSession();
		Audience audience3 = session3.get(Audience.class, 1999);
		session3.close();
		audience3.setName("Rabbit");

		Session session4 = sessionFactory.openSession();
		Audience audience4 = session4.get(Audience.class, 1999);
		session4.beginTransaction();
		session4.update(audience3);
		session4.getTransaction().commit();
		session4.close();

	}
}