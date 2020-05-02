package com.ratna.hibernate.crudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.dao.ShopDAO;
import com.ratna.hibernate.pojo.Shop;

public class HibernateCrudOperations {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		insertRecordsIntoShop(session, 15, false);
		System.out.println(getRequiredShopByID(session, 142, false));
		deleteRequiredRecordFromShop(session, 142, false);
		System.out.println(updateRequiredShopByID(session, 153, true));
		session.getTransaction().commit();
		session.close();

	}

	public static void insertRecordsIntoShop(Session session, int count, boolean insert) {
		if (insert) {
			ShopDAO.insertRequiredNumOfRecords(count, session);
		}
	}

	public static Shop getRequiredShopByID(Session session, int id, boolean retrieve) {
		Shop shop = null;
		if (retrieve) {
			shop = ShopDAO.getRequiredShopById(id, session);
		}
		return shop;
	}

	public static void deleteRequiredRecordFromShop(Session session, int id, boolean delete) {
		if (delete) {
			ShopDAO.deleteRequiredShopById(id, session);
		}
	}

	public static Shop updateRequiredShopByID(Session session, int id, boolean update) {
		Shop shop = null;
		if (update) {
			shop = ShopDAO.updateRequiredShopById(id, session);
		}
		return shop;
	}

}
