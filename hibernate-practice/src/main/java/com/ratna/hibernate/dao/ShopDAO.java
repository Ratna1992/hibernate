package com.ratna.hibernate.dao;

import java.util.Random;

import org.hibernate.Session;

import com.ratna.hibernate.pojo.Shop;

public class ShopDAO {

	public static void insertRequiredNumOfRecords(int numOfRecords, Session session) {
		Random r = new Random();
		for (int i = 1; i <= numOfRecords; i++) {
			Shop s = new Shop();
			s.setCity("shop city " + i);
			s.setName("Shop Name " + i);
			s.setRevenue(r.nextInt(1000000));
			session.save(s);

		}

	}

	public static Shop getRequiredShopById(int shopId, Session session) {
		// eager fetch because even we closed the session we can access it available in
		// cache
		Shop shop = session.get(Shop.class, shopId);
		return shop;
	}

	public static void deleteRequiredShopById(int shopId, Session session) {
		Shop shop = session.get(Shop.class, shopId);
		session.delete(shop);
	}

	public static Shop updateRequiredShopById(int shopId, Session session) {
		Shop shop = session.get(Shop.class, shopId);
		shop.setName("Ratna General Stores");
		session.update(shop);
		return shop;
	}

}
