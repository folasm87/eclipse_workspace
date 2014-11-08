package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.ISystemRoleBusinessService;

public class SystemRoleAction extends BaseAction {

	BusinessServiceFactory bsFactory;

	public BusinessServiceFactory getBsFactory() {
		return bsFactory;
	}

	public void setBsFactory(BusinessServiceFactory bsFactory) {
		this.bsFactory = bsFactory;
	}

	@Override
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		List<SystemRole> roles = fetchSystemRoles();
		request.setAttribute("SYSTEM_ROLES", roles);
		forward = mapping.findForward("success");
		return forward;
	}

	private List<SystemRole> fetchSystemRoles() throws Exception {
		List<SystemRole> systemRoles = new ArrayList<SystemRole>();
		ISystemRoleBusinessService systemRoleService = (ISystemRoleBusinessService) getBsFactory()
				.getFactory().getBean("systemRoleBS");
		systemRoles = systemRoleService.getSystemRoles();
		return systemRoles;
	}

}
