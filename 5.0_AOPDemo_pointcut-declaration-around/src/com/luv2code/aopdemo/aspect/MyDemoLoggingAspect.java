package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution (* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>> Executing @aroundGetFortune method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			result = "An exception happen but your aop catch that!";
		}
	
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " secs");
		return result;
		
	}
	
	@After("execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>> Executing @afterFindAccountsAdvice method: " + method);
	
		
	}
	
	@AfterThrowing(
			pointcut="execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>> Executing @afterThrowingFindAccountsAdvice method: " + method);
		
		myLogger.info("\n=====>>> Executing @afterThrowingFindAccountsAdvice: throw" + theExc);
		
	}
	
	
	@AfterReturning(
			pointcut="execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>> Executing @afterReturningFindAccountsAdvice method: " + method);
		
		myLogger.info("\n=====>>> Executing @afterReturningFindAccountsAdvice: return" + result);
		
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
		myLogger.info("\n=====>>> Executing @Before advice on addAcount()");
	}
	
}

