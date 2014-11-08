package com.multivision.ehrms.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {

	Logger log4j = Logger.getLogger(getClass());
	String startMessage = "Your action class process is initiated.";
	String completedMessage = "Your action class process is completed.";
	String exceptionMessage = "Oops! There is a problem in your action class process.";

	@Before("execution (* perform(..))")
	public void logBeforePeform() {
		System.out.println(startMessage);
		log4j.info(startMessage);
	}

	@AfterReturning("execution (* perform(..))")
	public void logAfterReturnPeform() {
		System.out.println(completedMessage);
		log4j.info(completedMessage);
	}

	@AfterThrowing("execution (* perform(..))")
	public void logAfterThrowPeform() {
		System.out.println(exceptionMessage);
		log4j.info(exceptionMessage);
	}

}
