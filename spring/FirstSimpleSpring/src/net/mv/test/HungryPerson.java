package net.mv.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.mv.flatware.*;
import net.mv.grub.*;

public class HungryPerson {
	
	public static void main(String[] args){
		//Food steak = new Steak(25);
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		Food steak = (Food) ctx.getBean("Steak");
		
		
		
		steak.getEaten();
		
		steak.printSize();
		steak.tasteDelicious();
		steak.rot();
		steak.setPlate();
		
	}

}
