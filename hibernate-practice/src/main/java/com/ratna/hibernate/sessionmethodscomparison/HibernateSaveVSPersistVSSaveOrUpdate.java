package com.ratna.hibernate.sessionmethodscomparison;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Audience;

public class HibernateSaveVSPersistVSSaveOrUpdate {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Audience a1 = new Audience();
		a1.setName("Ratli");
		Integer key = (Integer) session.save(a1);
		// saves an entity in to database and returns pk
		// if an entity already exists with pk it throws an exception
		System.out.println(key);

		Audience a2 = new Audience();
		a2.setName("Srili");
		session.persist(a2);
		// saves an entity in to database and returns void
		// if an entity already exists with pk it throws an exception
		a1.setName("Hello");
		session.saveOrUpdate(a1);
		// saves a record if not exists if available updates the record return type is
		// void

		session.getTransaction().commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		Audience a3 = new Audience();
		a3.setName("MruthyumJai");
		// save can insert record without transaction
		Serializable save = session2.save(a3);
		System.out.println(save);
		Audience a4 = new Audience();
		a4.setName("Mahadev");
		// persist cannont insert a record if there is no transaction
		session2.persist(a4);
		session2.close();

	}

}
