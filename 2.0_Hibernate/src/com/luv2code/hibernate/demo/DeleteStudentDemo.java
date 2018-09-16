package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating new student object...");
//			Student tempStudent = new Student("Paul",  "Wall", "paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			Student myStudent = session.get(Student.class, 4);
			
			myStudent.setFirstName("Jack");
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!" + myStudent);
			
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		
	}

}
