package app;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {

	
	public String greeting(String name);
}
