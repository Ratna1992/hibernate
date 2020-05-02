package com.ratna.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.dao.LaptopDAO;
import com.ratna.hibernate.pojo.Laptop;

public class HibernateHQL {

	public static void main(String[] args) {
		double b = 20000;
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// getAllLaptops
		List<Laptop> allLaptops = LaptopDAO.getAllLaptops(session, "from Laptop");
		allLaptops.forEach(System.out::println);

		// getAllLaptops whose price greater than 30000
		List<Laptop> filteredList = LaptopDAO.getAllLaptops(session, "from Laptop where price>30000");
		filteredList.forEach(System.out::println);

		// getRequiredLaptop whose brand is Laptop : 14
		Laptop requiredLaptop = LaptopDAO.getRequiredLaptop(session, "from Laptop where brand='Laptop : 14'");
		System.out.println(requiredLaptop);

		// getRequiredData whose brand is Laptop : 14
		Object[] requiredData = LaptopDAO.getRequiredData(session,
				"select brand,price from Laptop where brand='Laptop : 14'");
		Arrays.asList(requiredData).forEach(System.out::println);

		// getAllDataList
		List<Object[]> requiredDataList = LaptopDAO.getRequiredDataList(session, "select brand,price from Laptop ");
		requiredDataList.forEach(obj -> System.out.println(obj[0] + " :" + obj[1]));

		// getRequiredDataList
		List<Object[]> requiredList = LaptopDAO.getRequiredDataList(session,
				"select brand,price from Laptop l where l.price>40000 ");
		requiredList.forEach(obj -> System.out.println(obj[0] + " :" + obj[1]));

		// getTotals
		Double getTotals = LaptopDAO.getTotals(session, "select sum(price) from Laptop where price >20000 ");
		System.out.println(getTotals);

		// getTotals with positional params
		Double getTotalsPos = LaptopDAO.getTotalsUsingPositionalParameters(session,
				"select sum(price) from Laptop where price >:b ", b);
		System.out.println(getTotalsPos);

		// allLaptopsPagination
		List<Laptop> allLaptopsPagination = LaptopDAO.getAllLaptopsPagination(session, "from Laptop");
		allLaptopsPagination.forEach(System.out::println);

		// updateLaptop
		int updateLaptop = LaptopDAO.updateLaptop(session, "update Laptop set price=:price where brand=:brand", 60000d,
				"Laptop : 1");
		System.out.println(updateLaptop);

		// deleteLaptop
		int deleteLaptop = LaptopDAO.deleteLaptop(session, "delete from Laptop where brand=:brand", "Laptop : 1");
		System.out.println(deleteLaptop);

		session.getTransaction().commit();
	}

}
