package com.multivision.ehrms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.multivision.ehrms.business.SuperUser;

public abstract class BaseDispatchAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			HttpSession session = request.getSession(false);
			SuperUser superUser = (SuperUser) session.getAttribute("user");
			if (session != null || superUser != null) {
				forward = perform(mapping, form, request, response);
			}
		} catch (Exception ex) {
			Logger logger = Logger.getRootLogger();
			logger.trace(this.getClass(), ex);
			forward = mapping.findForward("failure");
		}
		return forward;
	}

	protected abstract ActionForward perform(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
