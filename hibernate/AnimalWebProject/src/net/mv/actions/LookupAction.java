package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.Animal;
import net.mv.dao.AnimalWebDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class LookupAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm dform = (DynaValidatorForm)form;
		
		final String id = dform.getString("id");
		System.out.println("Got id, id="+id);
		Animal result = AnimalWebDAO.lookup(id);
		System.out.println(result);
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		
		return mapping.findForward("lookupSuccess");
	}
}
