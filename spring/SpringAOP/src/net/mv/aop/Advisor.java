package net.mv.aop;

public class Advisor {

	public void beforeAdvisor(){
		System.out.println("Before Advice");
	}
	
	public void afterAdvisor(){
		System.out.println("After Advice!");
	}
}
