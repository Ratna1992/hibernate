package com.ratna.hibernate.inheritencemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Animal;
import com.ratna.hibernate.pojo.PetAnimal;
import com.ratna.hibernate.pojo.WildAnimal;

public class TablePerClassInheritence {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Animal a = new Animal();
		a.setName("animal");

		WildAnimal w = new WildAnimal();
		w.setName("lion");
		w.setColor("yellow");
		w.setWeight(350);

		PetAnimal p = new PetAnimal();
		p.setBreed("Labrador");
		p.setCost(15000);
		p.setName("Dog");
		
		session.save(a);
		session.save(w);
		session.save(p);

		session.getTransaction().commit();

	}

}
