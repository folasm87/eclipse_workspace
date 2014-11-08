package net.mv.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SimpleInterceptor {
	
	@PostConstruct 
	/*
	 * InvocationContext object that gives access to the method name, and parameter list
	 * that triggered the interceptor.
	*/
	public void init(InvocationContext ic){
		System.out.println("Post construct of the bean");
	}
	
	@PreDestroy
	public void destroy(InvocationContext ic){
		System.out.println("Pre destroy of the bean");
	}
	
	@AroundInvoke
	public Object perform(InvocationContext ic) throws Exception {
		
		System.out.println("Around invoke before for " + ic.getMethod().getName());
		
		Object retVal = ic.proceed();
		
		System.out.println("Around invoke after for " + ic.getMethod().getName());
		
		return retVal;
	}
}
