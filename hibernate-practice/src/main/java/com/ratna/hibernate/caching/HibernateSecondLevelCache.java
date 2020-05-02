package com.ratna.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.pojo.Author;

public class HibernateSecondLevelCache {

	public static void main(String[] args) {

		Author s = null;
		SessionFactory sessionFactory = HibernateSecondLevelCacheConfiguration.getSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		s = (Author) session1.get(Author.class, 1);
		System.out.println(s);
		session1.getTransaction().commit();
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		s = (Author) session2.get(Author.class, 1);
		System.out.println(s);
		session2.getTransaction().commit();
		session2.close();
	}

}
