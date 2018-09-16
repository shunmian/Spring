package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 1);
			
			if(tempInstructor != null) {
			
				session.delete(tempInstructor);
				session.getTransaction().commit();
				System.out.println("Delete Done!");
			}
			
			

			
			
		} catch (Exception e) {
			System.out.println("error!" + e);
			
			
		} finally {
			factory.close();
		}
		
	}

}
