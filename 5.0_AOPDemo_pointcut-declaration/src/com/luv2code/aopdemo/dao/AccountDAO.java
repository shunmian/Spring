package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(this.getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void doWork() {
		System.out.println(this.getClass() + ": DOING MY DB WORK: DO WORK");
	}
}
