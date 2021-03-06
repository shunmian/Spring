package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 4);
			

			session.delete(myStudent);
			session.getTransaction().commit();
			
			System.out.println("Done!" + myStudent);
			
			
		} catch (Exception e) {
			
		} finally {
			factory.close();
		}
		
	}

}
