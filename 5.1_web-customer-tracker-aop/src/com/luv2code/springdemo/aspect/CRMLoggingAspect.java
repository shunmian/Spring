package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinpoint) {
		String theMethod = theJoinpoint.getSignature().toShortString();
		myLogger.info("======> in @Before: calling method: " + theMethod);
		Object[] args = theJoinpoint.getArgs();
		
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}
	
	
	@AfterReturning(
				pointcut="forAppFlow()",
				returning="theResult"
			)
	private void afterReturning(JoinPoint theJoinpoint, Object theResult) {
		
		String theMethod = theJoinpoint.getSignature().toShortString();
		myLogger.info("======> in @AfterReturning: from method: " + theMethod);
		
		myLogger.info("======> in @AfterReturning: result: " + theResult);
		
	}
	
}
