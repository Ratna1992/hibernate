package com.ratna.hibernate.relationalmapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Crew;
import com.ratna.hibernate.pojo.Supervisor;

public class HibernateMTMMappingBiDirectionalWithTwoJoinTables {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Supervisor s1 = new Supervisor();
		s1.setName("Ratna");
		s1.setExperience("5 years as Lead Architect");
		
		Supervisor s2 = new Supervisor();
		s2.setName("Srinivas");
		s2.setExperience("15 years as Lead Manager");
		
		Supervisor s3 = new Supervisor();
		s3.setName("Ratna Srinivas");
		s3.setExperience("25 years as CEO");
		
		Crew c1 = new Crew();
		c1.setName("crew1");
		
		Crew c2 = new Crew();
		c2.setName("crew2");
		
		Crew c3 = new Crew();
		c3.setName("crew3");
		
		Collection<Crew> crew1 = s1.getCrew();
		crew1.add(c3);
		crew1.add(c2);
		
		Collection<Crew> crew2 = s2.getCrew();
		crew2.add(c3);
		crew2.add(c1);
		
		Collection<Crew> crew3 = s3.getCrew();
		crew3.add(c2);
		crew3.add(c1);
		
		s1.setCrew(crew1);
		s2.setCrew(crew2);
		s3.setCrew(crew3);
		
		Collection<Supervisor> supervisor1 = c1.getSupervisor();
		supervisor1.add(s1);
		supervisor1.add(s2);
		
		Collection<Supervisor> supervisor2 = c2.getSupervisor();
		supervisor2.add(s2);
		supervisor2.add(s3);
		
		Collection<Supervisor> supervisor3 = c3.getSupervisor();
		supervisor3.add(s3);
		supervisor3.add(s1);
		
		c1.setSupervisor(supervisor1);
		c1.setSupervisor(supervisor2);
		c1.setSupervisor(supervisor3);
		
		
		
		
		
		
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		

		session.getTransaction().commit();
	}

}
