package net.mv.action;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import app.HelloBeanRemote;

public class WelcomeAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		
		DynaActionForm dform = (DynaActionForm) form;
		
		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context ctx = new InitialContext(prop);
		
		HelloBeanRemote remote= (HelloBeanRemote)ctx.lookup("java:global/HelloWorldEJB/helloworldbean!app.HelloBeanRemote");
		
		String greet = remote.greeting(dform.getString("name"));
		
		HttpSession session = req.getSession();
		session.setAttribute("greeting", greet);
		
		return mapping.findForward("nameEntered");
		
	}

}
