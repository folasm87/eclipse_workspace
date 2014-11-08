package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.Dao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class RegisterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DynaActionForm dform  = (DynaActionForm) form;
		
		final String uname = dform.getString("username");
		final String pass = dform.getString("password");
		
		
		System.out.println(uname + " : " + pass);
		
		Dao dao = new Dao();
		
		dao.insertUserRecord(uname, pass);
		
		return mapping.findForward("insertSuccess");
	}
	

}
