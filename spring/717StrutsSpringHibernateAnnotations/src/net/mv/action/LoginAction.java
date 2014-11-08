package net.mv.action;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.business.BusinessDelegate;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.stereotype.Component;

//telling the spring container to create this bean, and link it to /login
@Component("/login")
public class LoginAction extends Action {

	//injecting BusinessDelegate into our LoginAction
	@Inject
	private BusinessDelegate busDelegate;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm df = (DynaActionForm)form;
		final String usr = df.getString("username");
		final String pwd = df.getString("password");
		
		boolean validUser = busDelegate.loginDAO(usr, pwd);
		
		if(validUser){
			return mapping.findForward("success");
		}else{
			return mapping.findForward("failure");
		}
	}
}








