package com.ratna.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.ratna.hibernate.caching.HibernateSecondLevelCacheConfiguration;
import com.ratna.hibernate.pojo.Author;

public class AuthorDAO {

	public List<Author> getStudents() {
		Session session = HibernateSecondLevelCacheConfiguration.getSessionFactory().openSession();
		return session.createQuery("from Author", Author.class).list();
	}

}
