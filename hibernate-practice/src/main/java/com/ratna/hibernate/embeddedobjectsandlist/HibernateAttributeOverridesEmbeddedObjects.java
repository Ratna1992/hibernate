package com.ratna.hibernate.embeddedobjectsandlist;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Address;
import com.ratna.hibernate.pojo.Person;

public class HibernateAttributeOverridesEmbeddedObjects {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person u = new Person();
		u.setName("Srinivas");
		u.setDob(new Date(1992, 9, 1));
		u.setMobile(8499899121l);

		Address a = new Address();
		a.setCity("Hyderabad");
		a.setState("Telangana");
		a.setPin(500081);
		a.setStreet("Ayyappa Society Sai Nagar");
		u.setHomeAddress(a);

		Address a1 = new Address();
		a1.setCity("Hyderabad");
		a1.setState("Telangana");
		a1.setPin(500081);
		a1.setStreet("DLF Building");
		u.setWorkAddress(a1);

		session.save(u);

		session.getTransaction().commit();

	}

}
