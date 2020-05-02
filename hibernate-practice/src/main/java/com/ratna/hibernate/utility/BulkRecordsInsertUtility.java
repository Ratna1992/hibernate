package com.ratna.hibernate.utility;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Employee;

public class BulkRecordsInsertUtility {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Random r = new Random();
		for (int i = 1; i <= 15; i++) {
			Employee e = new Employee();
			e.setAge(r.nextInt(100));
			e.setSalary(r.nextInt(50000));
			e.setName("Emp :" + i);
			session.save(e);
		}
		session.getTransaction().commit();

	}

}
