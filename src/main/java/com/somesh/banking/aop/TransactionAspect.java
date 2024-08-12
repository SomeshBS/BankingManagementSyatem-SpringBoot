package com.somesh.banking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TransactionAspect {

	@Around("execution(* com.somesh.banking.services.*.*(..))")
	public Object aroundTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("Around Before: " + joinPoint.getSignature().getName());

		Object result = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Around After: " + joinPoint.getSignature().getName());
		System.out.println("Around transaction completed transaction in " + timeTaken + " ms");

		return result;
	}

	@Before("execution(* com.somesh.banking.services.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before: " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.somesh.banking.services.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After: " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.somesh.banking.services.*.*(..))")
	public void afterReturningTransaction(JoinPoint joinPoint) {
		System.out.println("AfterReturning: " + joinPoint.getSignature().getName());
	}

}
