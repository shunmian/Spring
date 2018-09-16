package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = new Instructor("Susan", "Public", "Susan@luv2code.com");
			
			InstructorDetail tempInstructoreDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Video games");
			
			tempInstructor.setInstructorDetail(tempInstructoreDetail);

			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			System.out.println("Saving instructor2: " + tempInstructor);
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} catch (Exception e) {
			System.out.println("error!" + e);
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
