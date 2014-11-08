package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.Dao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DynaActionForm dform  = (DynaActionForm) form;
		
		final String username = dform.getString("username");
		final String password = dform.getString("password");

		
		System.out.println(username + " is signing in...");
		
		Dao dao = new Dao();
		
		boolean login = dao.retrieveLogin(username, password);
		
		if (login){
			return mapping.findForward("loginSuccess");
		}
		return mapping.findForward("loginFailure");
	}
	

}
