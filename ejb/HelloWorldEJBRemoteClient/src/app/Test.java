package app;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;


public class Test 
{
	public static void main(String[] args) 
	{
		try
		{
			Properties props = new Properties();
			
			props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			props.put(Context.PROVIDER_URL, "t3://localhost:7001");
			Context ctx = new InitialContext(props);
			//Return a remote object and cast it to a remote (business) interface type
			HelloBeanRemote remote = (HelloBeanRemote) ctx.lookup("java:global/HelloWorldEJB/helloworldbean!app.HelloBeanRemote");
			
			//Call Business methods
			System.out.println(remote.greeting("Fred"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
