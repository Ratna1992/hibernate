package com.ratna.hibernate.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ratna.hibernate.pojo.Student;

public class StudentDAO {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getAllStudents(Session session) {
		Criteria createCriteria = session.createCriteria(Student.class);
		return createCriteria.list();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getAllStudentsPagination(Session session, int pos1, int pos2) {
		Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.setFirstResult(pos1);
		createCriteria.setMaxResults(pos2);
		return createCriteria.list();
	}

	// get the records whose rollNumber is greater than 500
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getFilteredStudents(Session session) {
		Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(Restrictions.ge("rollNumber", 500))
				.add(Restrictions.in("id", Arrays.asList(98, 99, 100, 101))).addOrder(Order.desc("rollNumber"));
		return createCriteria.list();

	}

	// HCQL with Projection
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Integer> getFilteredStudentsByProjections(Session session) {
		Criteria c = session.createCriteria(Student.class);
		c.setProjection(Projections.max("rollNumber"));
		return c.list();
	}

	// get the records whose rollNumber between 100 and 500
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getFilteredStudentsBetween(Session session) {
		Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(Restrictions.between("rollNumber", 100, 500)).addOrder(Order.asc("rollNumber"));
		return createCriteria.list();

	}

	// restrictions or
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getFilteredStudentsOrRestriction(Session session) {
		Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(
				Restrictions.or(Restrictions.between("rollNumber", 100, 300), Restrictions.between("id", 90, 100)));
		return createCriteria.list();

	}

	// restrictions or
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getFilteredStudentsAndRestriction(Session session) {
		Criteria createCriteria = session.createCriteria(Student.class);
		createCriteria.add(
				Restrictions.and(Restrictions.between("rollNumber", 100, 300), Restrictions.between("id", 90, 100)));
		return createCriteria.list();

	}

	// queryby
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Student> getStudentsQueryBy(Session session) {
		Student s = new Student();
		s.setName("name :%");
		s.setRollNumber(565);
		Criteria createCriteria = session.createCriteria(Student.class);
		Example example = Example.create(s).enableLike();
		createCriteria.add(example);
		return createCriteria.list();

	}

}
