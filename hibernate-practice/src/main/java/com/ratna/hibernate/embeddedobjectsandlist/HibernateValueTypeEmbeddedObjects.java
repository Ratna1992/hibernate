package com.ratna.hibernate.embeddedobjectsandlist;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Address;
import com.ratna.hibernate.pojo.User;

public class HibernateValueTypeEmbeddedObjects {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User u = new User();
		u.setName("Ratna");
		u.setDob(new Date(1992, 9, 1));
		u.setMobile(8499899121l);

		Address a = new Address();
		a.setCity("Hyderabad");
		a.setState("Telangana");
		a.setPin(500081);
		a.setStreet("Ayyappa Society Sai Nagar");
		u.setAddress(a);

		session.save(u);

		session.getTransaction().commit();

	}

}
