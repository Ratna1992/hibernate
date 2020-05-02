package com.ratna.hibernate.hcql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.dao.StudentDAO;
import com.ratna.hibernate.pojo.Student;

public class HibernateCriteriaQueryLanguage {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// getAllStudents
		List<Student> allStudents = StudentDAO.getAllStudents(session);
		allStudents.forEach(System.out::println);

		// getAllStudentsPagination
		List<Student> allStudentsPagination = StudentDAO.getAllStudentsPagination(session, 1, 2);
		allStudentsPagination.forEach(System.out::println);

		// getAllStudents rollNumber greater than 500
		List<Student> rollNumber = StudentDAO.getFilteredStudents(session);
		rollNumber.forEach(System.out::println);

		// getAllStudents with projections
		List<Integer> projections = StudentDAO.getFilteredStudentsByProjections(session);
		projections.forEach(System.out::println);

		// getAllStudents rollNumber between 100 and 500
		List<Student> rollNumberBetween = StudentDAO.getFilteredStudentsBetween(session);
		rollNumberBetween.forEach(System.out::println);

		// or criteria
		List<Student> getFilteredStudentsOrRestriction = StudentDAO.getFilteredStudentsOrRestriction(session);
		getFilteredStudentsOrRestriction.forEach(System.out::println);

		// and criteria
		List<Student> getFilteredStudentsAndRestriction = StudentDAO.getFilteredStudentsAndRestriction(session);
		getFilteredStudentsAndRestriction.forEach(System.out::println);

		// queryBy
		List<Student> getStudentsQueryBy = StudentDAO.getStudentsQueryBy(session);
		getStudentsQueryBy.forEach(System.out::println);

		session.getTransaction().commit();

	}

}
