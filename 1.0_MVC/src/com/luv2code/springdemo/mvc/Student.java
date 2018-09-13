package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		this.countryOptions = new LinkedHashMap<>();
		
		this.countryOptions.put("BR", "Brazil");
		this.countryOptions.put("FR", "France");
		this.countryOptions.put("GE", "Germany");
		this.countryOptions.put("CN", "China");
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
