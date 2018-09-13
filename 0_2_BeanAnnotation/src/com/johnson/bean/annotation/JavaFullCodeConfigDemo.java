package com.johnson.bean.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFullCodeConfigDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(coach.exercise());
		
		System.out.println(coach.getFortune());
		
		System.out.println(coach.getEmail());
		
		System.out.println(coach.getTeam());
		
	}

}
