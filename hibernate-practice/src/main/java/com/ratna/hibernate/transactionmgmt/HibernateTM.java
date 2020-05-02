package com.ratna.hibernate.transactionmgmt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Student;

public class HibernateTM {

	public static void main(String[] args) {
		Transaction tx = null;
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Student s = new Student();
			s.setName("Rocky");
			s.setGender(true);
			s.setRollNumber(818899);
			session.save(s);

			if ("Rocky".equalsIgnoreCase(s.getName())) {
				throw new RuntimeException("Checking RTE");
			}
			tx.commit();
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println(rbe.getMessage());
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
