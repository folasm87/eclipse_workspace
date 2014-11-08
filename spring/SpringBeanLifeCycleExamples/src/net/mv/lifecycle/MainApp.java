package net.mv.lifecycle;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		LifeCycleBean lcb = (LifeCycleBean) ctx.getBean("LifeCycleBean");
		
		lcb.getMessage();
		
		ctx.registerShutdownHook();
		
		
		

	}

}
