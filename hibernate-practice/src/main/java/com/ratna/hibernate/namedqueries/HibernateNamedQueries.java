package com.ratna.hibernate.namedqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ratna.hibernate.configuration.HibernateConfiguration;
import com.ratna.hibernate.dao.EmployeeDAO;
import com.ratna.hibernate.pojo.Employee;

public class HibernateNamedQueries {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// get an employee by name
		List<Employee> employeeListByName = EmployeeDAO.getEmployeeListByName(session, "findEmployeeByName", "Emp :1");
		employeeListByName.forEach(System.out::println);

		// get an employee by age
		List<Employee> employeeListByAge = EmployeeDAO.getEmployeeListByAge(session, "findEmployeeByAge", 20);
		employeeListByAge.forEach(System.out::println);

		// get an employee by id
		Employee employeeListByNativeNamedQueryEmpId = EmployeeDAO.getEmployeeListByNativeNamedQueryEmpId(session,
				"findEmployeeByID", 102);
		System.out.println(employeeListByNativeNamedQueryEmpId);

		// get an employee by sal
		List<Employee> employeeListByNativeNamedQuerySalary = EmployeeDAO.getEmployeeListByNativeQuerySal(session,
				"findEmployeeBySalary", 8379);
		System.out.println(employeeListByNativeNamedQuerySalary);

		session.getTransaction().commit();
	}

}
