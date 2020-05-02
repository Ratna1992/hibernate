package com.ratna.hibernate.caching;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ratna.hibernate.pojo.Author;

public class HibernateSecondLevelCacheConfiguration {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				// creating configuration class
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:4444/test");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				// This property makes Hibernate generate the appropriate SQL for the chosen
				// database.
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				// using second level cache
				settings.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
				// using query cache
				settings.put(Environment.USE_QUERY_CACHE, "true");
				settings.put(Environment.CACHE_REGION_FACTORY,
						"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
				// setting properties to configuration class
				configuration.setProperties(settings);
				// adding beans to configuration
				configuration.addAnnotatedClass(Author.class);
				// creating service registry by passing configuration
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				// getting session object
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
