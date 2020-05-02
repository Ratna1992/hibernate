package com.ratna.hibernate.loading;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Address;
import com.ratna.hibernate.pojo.Customer;

public class HibernateLazyLoading {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer u = new Customer();
		u.setName("Lilly");
		u.setDob(new Date());
		u.setMobile(8499899121l);

		Address a = new Address();
		a.setCity("Hyderabad");
		a.setState("Telangana");
		a.setPin(500081);
		a.setStreet("Ayyappa Society Sai Nagar");

		Address a1 = new Address();
		a1.setCity("Vijyawada");
		a1.setState("Andhra");
		a1.setPin(521157);
		a1.setStreet("Annapurna Nilayam");

		u.getAddress().addAll(Arrays.asList(a, a1));

		session.save(u);
		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		u = session.get(Customer.class, u.getId());//lazy loading
		session.close();
		System.out.println(u.getAddress());//when ever u required address then only it trigger that address table

	}

}
