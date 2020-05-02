package com.ratna.hibernate.loading;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Address;
import com.ratna.hibernate.pojo.Servant;

public class HibernateEagerLoading {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Servant u = new Servant();
		u.setName("Ratna");
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
		u = session.get(Servant.class, u.getId());// aggressive loading
		session.close();
		System.out.println(u.getAddress());// already address also loaded

	}

}
