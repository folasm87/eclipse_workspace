package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.RoleMenuAccess;
import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.RecordRetrievalFailedException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IMenuBusinessService;
import com.multivision.ehrms.service.business.interfaces.IUserBusinessService;

public class HomePageAction extends Action {

	BusinessServiceFactory bsFactory;

	public BusinessServiceFactory getBsFactory() {
		return bsFactory;
	}

	public void setBsFactory(BusinessServiceFactory bsFactory) {
		this.bsFactory = bsFactory;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession(false);
		String username = removeIfUserExistsInSession(session);
		try {
			if (doAuthenticate(session, username)) {
				forward = mapping.findForward("success");
			}
		} catch (DataSourceConnectivityFailedException dbSourceexception) {
			ActionMessages messages = new ActionMessages();
			messages.add("DB_CON_FAILURE", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (RecordRetrievalFailedException rrfException) {
			ActionMessages messages = new ActionMessages();
			messages.add("DB_CON_FAILURE", new ActionMessage(
					"global.db.fetch.failure"));
			saveMessages(request, messages);
		}
		return forward;
	}

	private boolean doAuthenticate(HttpSession session, String username)
			throws Exception {
		boolean isAuthenticated = false;
		IUserBusinessService userService = (IUserBusinessService) getBsFactory()
				.getFactory().getBean("userBS");
		IMenuBusinessService moduleService = (IMenuBusinessService) getBsFactory()
				.getFactory().getBean("menuBS");
		SuperUser superUser = userService.getUserByKey(new SuperUser(),
				username);
		List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
		FilterConditions filterConditions = new FilterConditions(
				new RoleMenuAccess(), "systemRole.id", superUser
						.getSystemRole().getId() + "", "long");
		List<RoleMenuAccess> menList = new ArrayList<RoleMenuAccess>();
		criteriaList.add(filterConditions);
		menList = moduleService.getRoleMenu(criteriaList);
		if (superUser != null) {
			session.setAttribute("user", superUser);
			isAuthenticated = true;
		}
		session.setAttribute("menList", menList);
		return isAuthenticated;
	}

	@SuppressWarnings("rawtypes")
	private String removeIfUserExistsInSession(HttpSession session) {
		String username = session.getAttribute("SPRING_SECURITY_LAST_USERNAME")
				.toString();
		Enumeration sessionVars = session.getAttributeNames();
		while (sessionVars.hasMoreElements()) {
			String variable = (String) sessionVars.nextElement();
			session.removeAttribute(variable);
		}
		return username;
	}
}
