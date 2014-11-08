package net.mv.shopping;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ShoppingCart {
	public void addToCart(String item);
	public List<String> getCartItems();
	
	
	//The method that runs before the bean is removed from the container
	@Remove //Life cycle method
	public void remove();
}
