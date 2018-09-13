package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private String[] operationSystems;
	
	public String[] getOperationSystems() {
		return operationSystems;
	}

	public void setOperationSystems(String[] operationSystems) {
		this.operationSystems = operationSystems;
		
		for (String c : this.operationSystems) {
			System.out.println(c);
		}
	
	}

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

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
}
