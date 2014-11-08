package net.mv.shopping;

import java.util.ArrayList;
import java.util.List;










import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

import dataservice.ShoppingDAO;
import dataservice.ShoppingDAOImpl;

/**
 * Session Bean implementation class ShoppingCartBean
 */
//@Stateful(name="shoppingcart")
@Stateless(name="shoppingcart")
public class ShoppingCartBean implements ShoppingCart {

    /**
     * Default constructor. 
     */
    public ShoppingCartBean() {
        // TODO Auto-generated constructor stub
    }

    private ArrayList<String> cart;
    
	@Override
	public void addToCart(String item) {
		// TODO Auto-generated method stub
		
		System.out.println("Added " + item + " to cart.");
		
		ShoppingDAO shop = new ShoppingDAOImpl();
		shop.add(item);
		cart.add(item);
		
	}

	@Override
	public List<String> getCartItems() {
		// TODO Auto-generated method stub
		System.out.println("Getting cart items... ");
		return cart;
	}

	@Override
	@Remove
	public void remove() {
		// TODO Auto-generated method stub
		
		System.out.println("Bean is removed");
		
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Post construction of bean");
		cart = new ArrayList<String>();
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Pre destruction of bean");
	}
	
	@PrePassivate
	public void passive(){
		System.out.println("Pre passivation of bean");
	}
	
	@PostActivate
	public void activate(){
		System.out.println("Post activation of bean");
	}

}
