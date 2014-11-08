package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.DAO;

import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

public class InsertAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		DynaValidatorForm dform = (DynaValidatorForm) form;
		
		final String fname = dform.getString("fname");
		final String lname = dform.getString("lname");
		final String username = dform.getString("username");
		final String password = dform.getString("password");
		final String super_user = dform.getString("super_user");
		
		//DAO dao = new DAO();
		DAO.insertUser(username, password, fname, lname, super_user);
		return mapping.findForward("Inserted");
		
		
		
	}

}
