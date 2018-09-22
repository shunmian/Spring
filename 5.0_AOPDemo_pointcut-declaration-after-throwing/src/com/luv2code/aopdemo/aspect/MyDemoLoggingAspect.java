package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut="execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>> Executing @afterThrowingFindAccountsAdvice method: " + method);
		
		System.out.println("\n=====>>> Executing @afterThrowingFindAccountsAdvice: throw" + theExc);
		
	}
	
	
	@AfterReturning(
			pointcut="execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>> Executing @afterReturningFindAccountsAdvice method: " + method);
		
		System.out.println("\n=====>>> Executing @afterReturningFindAccountsAdvice: return" + result);
		
		convertAccountNamesToUppderCase(result);
	}
	
	
	private void convertAccountNamesToUppderCase(List<Account> result) {
		// TODO Auto-generated method stub
		for (Account tempAccount: result) {
			String originalName = tempAccount.getName();
			tempAccount.setName(originalName.toUpperCase());
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAcount()");
	}
	
}

