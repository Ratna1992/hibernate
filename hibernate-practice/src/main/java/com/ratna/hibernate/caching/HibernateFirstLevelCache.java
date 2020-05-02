package com.ratna.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Student;

public class HibernateFirstLevelCache {

	public static void main(String[] args) {
		Student s = null;
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		// first level cache available in session1
		s = (Student) session1.get(Student.class, 1);
		System.out.println(s);
		s = (Student) session1.get(Student.class, 1);
		System.out.println(s);
		session1.getTransaction().commit();
		session1.close();

		// as first level cache is session level if we created
		// session2 again it triggers query
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		s = (Student) session2.get(Student.class, 1);
		System.out.println(s);
		session2.getTransaction().commit();
		session2.close();
	}

}
