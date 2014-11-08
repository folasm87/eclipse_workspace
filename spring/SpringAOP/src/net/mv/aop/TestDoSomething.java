package net.mv.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDoSomething {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
		DoSomething ds = (DoSomething)ctx.getBean("doStuff");
		
		ds.method();
		
		System.out.println("<---------------->");
		
		ds.method2();

	}

}
