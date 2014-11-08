package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.DAO;
import net.mv.dao.T_User;

import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

public class LoginAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		DynaValidatorForm dform = (DynaValidatorForm) form;
		
		final String uname = dform.getString("username");
		final String password = dform.getString("password");
		
		
		
		//DAO dao = new DAO();
		T_User user = DAO.retrieveUser(uname, password);
		
		
		
		if(user != null){
			
			String status = user.getSuper_user().toLowerCase();
			System.out.println("Is Logger Super? " + status);
			
			HttpSession sess = req.getSession();
			
			sess.setAttribute("user", user);
			sess.setAttribute("user_id", user.getT_USER_ID());
			sess.setAttribute("user_tsheet", user.getTimesheets());
				
			if(status.equals("true")){
				System.out.println("What a Super Login!!!");
				return mapping.findForward("Login_Super");
			}
			System.out.println("Login Success!!!");
			return mapping.findForward("Login_Success");
		}
		System.out.println("FAIL!!!");
		return mapping.findForward("Login_Failure");
		
		
		
	}

}
