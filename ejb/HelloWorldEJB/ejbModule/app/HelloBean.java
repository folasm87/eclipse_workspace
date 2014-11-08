package app;

import javax.ejb.Stateless;


@Stateless(name="helloworldbean")
public class HelloBean implements HelloBeanRemote{

	public HelloBean(){
		
		
	}

	@Override
	public String greeting(String name) {
		
		return "Hello, " + name + " from Mark's Stateless Session Bean";
	}
}
