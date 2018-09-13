package com.johnson.bean.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFullCodeConfigDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach coach = context.getBean("swimCoach", Coach.class);
		
		System.out.println(coach.exercise());
		
		System.out.println(coach.getFortune());
		
	}

}
