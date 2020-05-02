package com.ratna.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.ratna.hibernate.pojo.Employee;

public class EmployeeDAO {

	public static List<Employee> getEmployeeListByName(Session session, String query, String name) {
		@SuppressWarnings("unchecked")
		Query<Employee> namedQuery = session.getNamedQuery(query);
		namedQuery.setParameter("name", name);
		return namedQuery.list();
	}

	public static List<Employee> getEmployeeListByAge(Session session, String query, int age) {
		@SuppressWarnings("unchecked")
		Query<Employee> namedQuery = session.getNamedQuery(query);
		namedQuery.setParameter("age", age);
		return namedQuery.list();
	}

	@SuppressWarnings("unchecked")
	public static Employee getEmployeeListByNativeNamedQueryEmpId(Session session, String query, int empId) {
		NativeQuery<Employee> namedNativeQuery = session.getNamedNativeQuery(query);
		namedNativeQuery.addEntity(Employee.class);
		namedNativeQuery.setParameter("empId", empId);
		return namedNativeQuery.uniqueResult();
	}

	public static List<Employee> getEmployeeListByNativeQuerySal(Session session, String query, int salary) {
		@SuppressWarnings("unchecked")
		Query<Employee> namedQuery = session.getNamedQuery(query);
		namedQuery.setParameter("salary", salary);
		return namedQuery.list();
	}

}
