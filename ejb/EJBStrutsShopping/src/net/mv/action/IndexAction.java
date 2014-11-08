package net.mv.action;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.shopping.ShoppingCart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


public class IndexAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		
		DynaActionForm dform = (DynaActionForm) form;
		
		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context ctx = new InitialContext(prop);
		
		//elloBeanRemote remote= (HelloBeanRemote)ctx.lookup("java:global/HelloWorldEJB/helloworldbean!app.HelloBeanRemote");
		
		ShoppingCart cart = (ShoppingCart)ctx.lookup("java:global/ShoppingCart/shoppingcart!net.mv.shopping.ShoppingCart");
		//java:global/HelloWorldEJB/
		List<String> items = cart.getCartItems();
		
		HttpSession session = req.getSession();
		session.setAttribute("items", items);
		
		return mapping.findForward("displayIndex");
		
	}

}
