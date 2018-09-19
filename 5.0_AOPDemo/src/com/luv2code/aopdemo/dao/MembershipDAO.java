package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addSillyAccount() {
		System.out.println(this.getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		return "here";
	}
}
