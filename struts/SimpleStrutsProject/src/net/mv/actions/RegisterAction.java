package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.mv.forms.RegisterForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


//this class contains the code that is the logic that would happen in a servlet
public class RegisterAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//bring in the form, cast it to the type that we just created
		RegisterForm rform = (RegisterForm)form;
		
		//take the strings out of the form so I can work with them 
		String user = rform.getUsername();
		String pass = rform.getPassword();
		String name = rform.getName();
		String dob = rform.getDob();
		
		//business logic
		System.out.println("Name: " + name);
		System.out.println("Born: " + dob);
		System.out.println("Username: " + user);
		System.out.println("Password: " + pass);
		
		
		//give the logical name of the next destination (configured in struts-config.xml)
		return mapping.findForward("registerSuccess");
	}
}
