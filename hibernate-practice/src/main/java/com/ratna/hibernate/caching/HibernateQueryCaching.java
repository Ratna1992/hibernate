package com.ratna.hibernate.caching;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ratna.hibernate.pojo.Author;

public class HibernateQueryCaching {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateSecondLevelCacheConfiguration.getSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Query<Author> createQuery = session1.createQuery("from Author");
		createQuery.setCacheable(true);
		List<Author> list = createQuery.list();
		list.forEach(System.out::println);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query<Author> createQuery1 = session2.createQuery("from Author");
		createQuery1.setCacheable(true);
		List<Author> list1 = createQuery1.list();
		list1.forEach(System.out::println);
		session2.getTransaction().commit();
		session2.close();
	}

}
