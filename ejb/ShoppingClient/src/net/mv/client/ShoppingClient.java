package net.mv.client;

import java.util.Iterator;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import net.mv.shopping.ShoppingCart;

public class ShoppingClient {
	
	public static void main(String[] args) throws Exception{
		
		Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context envCtx = new InitialContext(env);
		
		ShoppingCart cart = (ShoppingCart) envCtx.lookup("shoppingcart#net.mv.shopping.ShoppingCart");
		
		cart.addToCart("iPhone 6");
		cart.addToCart("iPad 7");
		cart.addToCart("Macbook Air");
		
		Iterator<String> itr = cart.getCartItems().iterator();
		while(itr.hasNext()){
			
			itr.next();
		}
		
		cart.remove();
		
		
	}

}
