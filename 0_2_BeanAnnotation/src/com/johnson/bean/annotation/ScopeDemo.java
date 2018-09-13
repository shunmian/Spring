package com.johnson.bean.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coachA = context.getBean("tennisCoach", Coach.class);
		
		Coach coachB = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("coachA and coachB reference the same object: " + (coachA == coachB));
		
		
		System.out.println("coachA: " + coachA);
		
		System.out.println("coachB: " + coachB);
		

	}

}
