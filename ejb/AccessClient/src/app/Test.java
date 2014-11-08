package app;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import business.ejb.CallerBeanRemote;


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
			CallerBeanRemote remote = (CallerBeanRemote) ctx.lookup("java:global/AccessEAR/AccessEJB/callerBean!business.ejb.CallerBeanRemote");
			
			//Call Business methods
			System.out.println(remote.retrieveName(103));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
