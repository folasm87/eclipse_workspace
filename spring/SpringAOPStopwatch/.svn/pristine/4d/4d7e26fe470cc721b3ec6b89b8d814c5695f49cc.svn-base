package net.mv.aop;


import org.aspectj.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Advisor {

	@Around("execution(* net.mv.aop.*.method1(..))")
	public void timeThisMethod(ProceedingJoinPoint jp) throws Throwable{
		
		long time = System.nanoTime();
		System.out.println("Begin around advice!");
		
		jp.proceed();
		
		long deltaTime = System.nanoTime() - time;
		
		System.out.println("The execution time for method1 is " + deltaTime*1e-6+" milliseconds");
	}
}
