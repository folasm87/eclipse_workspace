package net.mv.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.mv.app.CalculatorRemote;

public class CalculatorClient {

	public static void main(String[] args) throws NamingException {
		
		
		Properties props = new Properties();
		
		props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		props.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context ctx = new InitialContext(props);
		
		CalculatorRemote remote = (CalculatorRemote)ctx.lookup("java:global//Calculator/calculate!net.mv.app.CalculatorRemote");
		
		System.out.println("The sum of 423 and 27 is " + remote.add(423, 27));
		System.out.println("7 to the second power is  " + remote.power(7, 2));
		System.out.println("The area of a circle with a diameter of 10 is  " + remote.areaCircle(10));

	}

}
