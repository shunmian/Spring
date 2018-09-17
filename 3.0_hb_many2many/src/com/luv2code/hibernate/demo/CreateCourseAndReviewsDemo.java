package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("Dota2");
		
			
			System.out.println("Saving the course");
			session.save(tempCourse);
			System.out.println("Saving completed: " + tempCourse);
	
			Student tempStudent1 = new Student("John", "Doe", "john@luv2c0de.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			System.out.println("Saving the course");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			System.out.println("Saving completed: " + tempCourse.getStudents());
			
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
