package com.johnson.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private Fortune fortune;

////	@Autowired
//	public TennisCoach(Fortune fortune) {
//		this.fortune = fortune;
//	}
	
	public TennisCoach() {
		System.out.println("Inside Tennis Coach");
	}

	
	@Autowired
	public void setFortune(Fortune fortune) {
		System.out.println("Inside setFortune");
		this.fortune = fortune;
	}
	
	@Override
	public String exercise() {
		return "Tennis 10 mins";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return this.fortune.getFortune();
	}

}
