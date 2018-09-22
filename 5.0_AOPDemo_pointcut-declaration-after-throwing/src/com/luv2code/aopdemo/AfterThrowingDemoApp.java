package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = null;
				
		try {
			boolean shouldThrowExcpetion = false;
			theAccounts = theAccountDAO.findAccounts(shouldThrowExcpetion);
		} catch (Exception e) {
			System.out.println("caught exception: " + e);
		}
		
		System.out.println("\n: AfterThrowingDemoApp");

		System.out.println("\n: " + theAccounts);
		
		// close the context
		context.close();
		
	}

}
