package com.johnson.bean.annotation;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private Fortune fortune;
	
	@Value("${foo.team}")
	private String team;
	
	@Value("${foo.email}")
	private String email;
	
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
