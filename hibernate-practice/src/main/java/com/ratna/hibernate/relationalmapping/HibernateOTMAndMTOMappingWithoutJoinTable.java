package com.ratna.hibernate.relationalmapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.pojo.Answer;
import com.ratna.hibernate.pojo.Question;

public class HibernateOTMAndMTOMappingWithoutJoinTable {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Question q = new Question();
		q.setQuestion("When Lockdown completes in India?");

		Answer a1 = new Answer();
		a1.setAnswer("May 03 2020");
		a1.setQuestion(q);

		Answer a2 = new Answer();
		a2.setAnswer("A million Dollar question");
		a2.setQuestion(q);

		Collection<Answer> answer = q.getAnswer();
		answer.add(a1);
		answer.add(a2);

		q.setAnswer(answer);

		session.save(q);
		/*
		 * session.save(a1); session.save(a2); if we used cascade type no need to save
		 * externally
		 */

		session.getTransaction().commit();

	}

}
