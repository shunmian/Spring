package com.johnson.bean.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("happyFortune")
	private Fortune fortune;

////	@Autowired
//	public TennisCoach(Fortune fortune) {
//		this.fortune = fortune;
//	}
	
	public TennisCoach() {
		System.out.println("Inside Tennis Coach");
	}

	
//	@Autowired
//	public void laugh(Fortune fortune) {
//		System.out.println("Inside setFortune");
//		this.fortune = fortune;
//	}
	
	@PostConstruct
	public void doSomeInit() {
		System.out.println("inside post init");
	}
	
	@PreDestroy
	public void doSomeClean() {
		System.out.println("inside pre destroy");
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
