package com.ratna.hibernate.embeddedobjectsandlist;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Account;
import com.ratna.hibernate.pojo.AccountSecret;

public class HibernateEmbeddedId {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Account a = new Account();
		a.setAccountNumber(123456789);
		a.setBranch("MLA Colony");
		a.setIfscCode("IFSC12345");
		AccountSecret accountSecret = new AccountSecret();
		accountSecret.setAccountStartDate(new Date());
		accountSecret.setMobileNumber(8499899121l);
		a.setLoginId(accountSecret);
		session.save(a);
		session.getTransaction().commit();

	}

}
