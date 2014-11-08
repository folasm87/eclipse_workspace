package net.mv.interceptor;

import javax.ejb.Remote;
import javax.interceptor.Interceptors;

@Remote
public interface SimpleBeanRemote {
	
	//declaring method level interceptors
	@Interceptors(SimpleInterceptor.class)
	void doSomething();

}
