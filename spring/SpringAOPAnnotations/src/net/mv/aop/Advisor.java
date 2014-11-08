package net.mv.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advisor {
	
	@Before("execution(* net.mv.aop.*.method1(..))")
	public void beforeAdvice(){
		System.out.println("Before Advice");
	}
	
	@After("execution(* net.mv.aop.*.method1(..))")
	public void afterAdvice(){
		System.out.println("After Advice!");
	}
	
	@Around("execution(* net.mv.aop.*.method2(..))")
	public void moreAdvice(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("Begin around advice");
		jp.proceed();
		System.out.println("Finish around advice!");
	}
}
