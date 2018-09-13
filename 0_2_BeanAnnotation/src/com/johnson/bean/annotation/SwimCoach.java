package com.johnson.bean.annotation;

public class SwimCoach implements Coach {
	
	private Fortune fortune;
	
	public SwimCoach(Fortune fortune) {
		this.fortune = fortune;
	}

	@Override
	public String exercise() {
		// TODO Auto-generated method stub
		return "Swim 100 meters";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return this.fortune.getFortune();
	}

}
