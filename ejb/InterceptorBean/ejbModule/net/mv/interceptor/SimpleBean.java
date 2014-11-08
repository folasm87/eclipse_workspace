package net.mv.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;


@Stateless(name = "simple")
//class level interceptor
@Interceptors(AnotherInterceptor.class)
public class SimpleBean implements SimpleBeanRemote {
	
	//method level interceptor
	@Interceptors(SimpleInterceptor.class)
	@Override
	public void doSomething() {
		//interceptors should be used for cross cutting converns (abstracting logging, authentication
		//etc out of your bus logic
		
		System.out.println("Some method of SimpleBean");
		
	}
	
	

}
