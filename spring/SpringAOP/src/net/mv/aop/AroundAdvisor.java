package net.mv.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvisor {
	
	public void moreAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Begin around advice!");
		joinPoint.proceed();
		System.out.println("Finish around advice!");
	}

}
