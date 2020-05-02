package com.ratna.hibernate.sql;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.dao.LaptopDAO;
import com.ratna.hibernate.pojo.Laptop;

public class HibernateSQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// getAllLaptops whose price greater than 30000
		List<Laptop> filteredList = LaptopDAO.getListAsNativeSQL(session, "select * from laptop where price>30000");
		filteredList.forEach(System.out::println);

		// getAllLaptops whose price greater than 30000
		@SuppressWarnings("rawtypes")
		List filteredLists = LaptopDAO.getRequiredFieldListAsNativeSQL(session,
				"select brand,price from laptop where price>30000");
		filteredLists.forEach(obj -> {
			@SuppressWarnings("rawtypes")
			Map map = (Map) obj;
			System.out.println(map.get("brand") + " " + map.get("price"));
		});

		session.getTransaction().commit();

	}

}
