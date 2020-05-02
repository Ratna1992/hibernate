package com.ratna.hibernate.inheritencemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.FourWheeler;
import com.ratna.hibernate.pojo.TwoWheeler;
import com.ratna.hibernate.pojo.Vehicle;

public class JoinedStrategyInheritence {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle v = new Vehicle();
		v.setName("Vehicle");
		
		TwoWheeler t = new TwoWheeler();
		t.setName("bike");
		t.setControlType("handle");
		t.setPrice(80000);
		
		FourWheeler f = new FourWheeler();
		f.setName("car");
		f.setPrice(4500000);
		f.setControlType("steering");
		
		session.save(f);
		session.save(t);
		session.save(v);

		session.getTransaction().commit();

	}

}
