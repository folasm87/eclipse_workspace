package net.mv.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTimed {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Timed timed = (Timed)ctx.getBean("timed");
		
		timed.method1();
		
		System.out.println("Done");
	}
}
