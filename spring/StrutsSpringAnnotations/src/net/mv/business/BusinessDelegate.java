package net.mv.business;

import org.springframework.stereotype.Component;

//annotation to let the spring container know that this is a bean
@Component
public class BusinessDelegate {
	
	public boolean loginDAO(String user, String pwd){
		//calls the dao class to check from DB
		
		
		return false;
		
	}
}
