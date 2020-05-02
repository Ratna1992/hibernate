package com.ratna.hibernate.relationalmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Doctor;
import com.ratna.hibernate.pojo.Patient;

public class HibernateOTOMappingBiDirectional {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Patient p = new Patient();
		p.setPname("dummy");
		p.setDisease("dummy");
		 
		Doctor d = new Doctor();
		d.setDname("original");
		d.setSpecialization("dummy");
		d.setPatient(p);
		
		p.setDoctor(d);
		
		session.save(d);
		
		session.getTransaction().commit();

	}

}
