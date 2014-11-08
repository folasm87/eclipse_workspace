package net.mv.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AnotherInterceptor {
	@AroundInvoke
	public Object perform(InvocationContext ic) throws Exception{
		System.out.println("Before around invoke (class level) " + ic.getMethod().getName());
		Object retVal = ic.proceed();
		System.out.println("After around invoke (class level) " + ic.getMethod().getName());
		return retVal;
		
		
	}
}
