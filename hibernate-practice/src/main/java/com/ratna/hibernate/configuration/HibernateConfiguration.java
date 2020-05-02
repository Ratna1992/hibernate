package com.ratna.hibernate.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ratna.hibernate.pojo.Account;
import com.ratna.hibernate.pojo.Animal;
import com.ratna.hibernate.pojo.Answer;
import com.ratna.hibernate.pojo.Audience;
import com.ratna.hibernate.pojo.Client;
import com.ratna.hibernate.pojo.ContractTeacher;
import com.ratna.hibernate.pojo.Country;
import com.ratna.hibernate.pojo.Crew;
import com.ratna.hibernate.pojo.Customer;
import com.ratna.hibernate.pojo.Doctor;
import com.ratna.hibernate.pojo.Employee;
import com.ratna.hibernate.pojo.FourWheeler;
import com.ratna.hibernate.pojo.Laptop;
import com.ratna.hibernate.pojo.Owner;
import com.ratna.hibernate.pojo.Patient;
import com.ratna.hibernate.pojo.PermanentTeacher;
import com.ratna.hibernate.pojo.Person;
import com.ratna.hibernate.pojo.PetAnimal;
import com.ratna.hibernate.pojo.Question;
import com.ratna.hibernate.pojo.RentHouse;
import com.ratna.hibernate.pojo.Servant;
import com.ratna.hibernate.pojo.Shop;
import com.ratna.hibernate.pojo.State;
import com.ratna.hibernate.pojo.Student;
import com.ratna.hibernate.pojo.Supervisor;
import com.ratna.hibernate.pojo.Teacher;
import com.ratna.hibernate.pojo.Theater;
import com.ratna.hibernate.pojo.TwoWheeler;
import com.ratna.hibernate.pojo.User;
import com.ratna.hibernate.pojo.Vehicle;
import com.ratna.hibernate.pojo.WildAnimal;

public class HibernateConfiguration {

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
				// setting properties to configuration class
				configuration.setProperties(settings);
				// adding beans to configuration
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Laptop.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(PermanentTeacher.class);
				configuration.addAnnotatedClass(ContractTeacher.class);
				configuration.addAnnotatedClass(Animal.class);
				configuration.addAnnotatedClass(PetAnimal.class);
				configuration.addAnnotatedClass(WildAnimal.class);
				configuration.addAnnotatedClass(Vehicle.class);
				configuration.addAnnotatedClass(TwoWheeler.class);
				configuration.addAnnotatedClass(FourWheeler.class);
				configuration.addAnnotatedClass(Shop.class);
				configuration.addAnnotatedClass(Patient.class);
				configuration.addAnnotatedClass(Doctor.class);
				configuration.addAnnotatedClass(Theater.class);
				configuration.addAnnotatedClass(Audience.class);
				configuration.addAnnotatedClass(Owner.class);
				configuration.addAnnotatedClass(RentHouse.class);
				configuration.addAnnotatedClass(Question.class);
				configuration.addAnnotatedClass(Answer.class);
				configuration.addAnnotatedClass(Supervisor.class);
				configuration.addAnnotatedClass(Crew.class);
				configuration.addAnnotatedClass(State.class);
				configuration.addAnnotatedClass(Country.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Person.class);
				configuration.addAnnotatedClass(Account.class);
				configuration.addAnnotatedClass(Client.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Servant.class);
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
