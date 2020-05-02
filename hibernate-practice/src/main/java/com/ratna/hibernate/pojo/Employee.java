package com.ratna.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findEmployeeByName", query = "from Employee e where e.name=:name"),
		@NamedQuery(name = "findEmployeeByAge", query = "from Employee e where e.age=:age") })
@NamedNativeQueries({ @NamedNativeQuery(name = "findEmployeeByID", query = "select * from employee where empId=:empId"),
		@NamedNativeQuery(name = "findEmployeeBySalary", query = "select * from employee where salary=:salary", resultClass = Employee.class) })
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	private Integer empId;

	@Column
	private String name;

	@Column
	private Integer salary;

	@Column
	private Integer age;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

}
