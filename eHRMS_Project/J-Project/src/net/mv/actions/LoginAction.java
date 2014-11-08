package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.DAO;
import net.mv.dao.User;
import net.mv.forms.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


//this class contains the code that is the logic that would happen in a servlet
public class LoginAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//bring in the form, cast it to the type that we just created
		DynaActionForm lform = (DynaActionForm)form;
		
		//take the strings out of the form so I can work with them 
		String username = lform.getString("username");
		String password = lform.getString("password");
		
		//business logic
		System.out.println(username + ", " + password);
		
		DAO dao = new DAO();
		
		User user = dao.retrieveUser(username, password);
		
		if (user != null){
			
			System.out.println(user.getFname() + " " + user.getLname() + " logged in.");
			return mapping.findForward("loginSuccess");
		}
		
		
		//give the logical name of the next destination (configured in struts-config.xml)
		return mapping.findForward("loginFailure");
	}
}