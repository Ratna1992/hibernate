package com.ratna.hibernate.inheritencemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.ContractTeacher;
import com.ratna.hibernate.pojo.PermanentTeacher;
import com.ratna.hibernate.pojo.Teacher;

public class TablePerHierarchyInheritence {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Teacher t = new Teacher();
		t.setName("principal");

		ContractTeacher c = new ContractTeacher();
		c.setContract_duration("60 days");
		c.setPay_per_hour(1200);
		c.setName("contract teacher");

		PermanentTeacher p = new PermanentTeacher();
		p.setName("permanent teacher");
		p.setSalary(50000);
		p.setBonus(20);

		session.save(t); 
		session.save(c);
		session.save(p);

		session.getTransaction().commit();

	}

}
