package net.mv.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.mv.interceptor.SimpleBeanRemote;

public class InterceptorClient {

	public static void main(String[] args) throws NamingException {
		Properties env = new Properties();
		
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context envCtx = new InitialContext(env);
		
		//must include the interceptor in the jar file for the client
		//must use name="simple" in SimpleBean for global lookup
		
		SimpleBeanRemote sim = (SimpleBeanRemote) envCtx.lookup("java:global/InterceptorBean/simple!net.mv.interceptor.SimpleBeanRemote");
		/*
		 * if you use [mappedName = "simple"] in your Interface
		 * then use:
		 * SimpleBeanRemote sim = (SimpleBeanRemote) envCtx.lookup("simple#net.mv.interceptor.SimpleBeanRemote");
		 * */
		sim.doSomething();

	}

}
