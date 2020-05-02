package com.ratna.hibernate.relationalmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Audience;
import com.ratna.hibernate.pojo.Theater;

public class HibernateOTOMappingUniDirectional {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Audience a = new Audience();
		a.setName("Srinivas");

		Theater t = new Theater();
		t.setAudience(a);
		t.setName("IMAX");
		session.save(t);
		session.save(a);

		session.getTransaction().commit();

	}

}
