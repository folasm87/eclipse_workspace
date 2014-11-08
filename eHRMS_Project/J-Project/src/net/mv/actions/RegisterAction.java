package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.mv.dao.DAO;
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
		
		String username = rform.getUsername();
		String password = rform.getPassword();
		String fname = rform.getFname();
		String lname = rform.getLname();
		String role = rform.getRole();
		String email = rform.getEmail();
		String phone = rform.getPhone();
		
		//business logic
		System.out.println("Name: " + fname + " " + lname);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		
		//DAO dao = new DAO();
		boolean success = DAO.insertUser(username, password, fname, lname, role, email, phone);
		
		if (success){
			return mapping.findForward("registerSuccess");
		}
		//give the logical name of the next destination (configured in struts-config.xml)
		return mapping.findForward("registerFailure");
	}
}
