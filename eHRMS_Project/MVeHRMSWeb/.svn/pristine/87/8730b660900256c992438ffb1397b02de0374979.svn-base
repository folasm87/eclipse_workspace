package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.multivision.ehrms.action.form.RoleAccessForm;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.ParentMenuManagement;
import com.multivision.ehrms.business.RoleMenuAccess;
import com.multivision.ehrms.business.SubMenuManagement;
import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IMenuBusinessService;
import com.multivision.ehrms.service.business.interfaces.ISystemRoleBusinessService;

public class MenuAccessAction extends BaseDispatchAction {
	private Logger logger = Logger.getRootLogger();
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
		if (request.getParameter("method") != null) {
			String parameter = request.getParameter("method");
			if (parameter.equalsIgnoreCase("list")) {
				forward = list(mapping, form, request, response);
			}
			if (parameter.equalsIgnoreCase("save")) {
				forward = save(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing menu information");
		ActionForward forward = null;
		HttpSession session = request.getSession(false);
		RoleAccessForm roleAccessForm = (RoleAccessForm) form;
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			roleAccessForm.setSystemId(id);
		}
		IMenuBusinessService moduleService = (IMenuBusinessService) getBsFactory()
				.getFactory().getBean("menuBS");
		List<ParentMenuManagement> parentMenuList = moduleService
				.getParentMenuDetails();
		List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
		FilterConditions filterConditions = new FilterConditions(
				new RoleMenuAccess(), "systemRole.id", id, "long");
		List<RoleMenuAccess> menList = new ArrayList<RoleMenuAccess>();
		criteriaList.add(filterConditions);
		menList = moduleService.getRoleMenu(criteriaList);
		SystemRole systemRole = new SystemRole();
		populateRoleList(systemRole, menList, session);
		List<SubMenuManagement> subMenuList = moduleService.getSubMenuDetails();
		session.setAttribute("parentMenuList", parentMenuList);
		session.setAttribute("subMenuList", subMenuList);
		if (menList.size() == 0) {
			forward = mapping.findForward("list");
		} else {
			forward = mapping.findForward("edit");
		}
		return forward;
	}

	@SuppressWarnings("unchecked")
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("save menu information");
		ActionForward forward = null;
		HttpSession session = request.getSession(false);
		RoleAccessForm roleAccessForm = (RoleAccessForm) form;
		List<SystemRole> systemRoles = new ArrayList<SystemRole>();
		ISystemRoleBusinessService systemRoleService = (ISystemRoleBusinessService) getBsFactory()
				.getFactory().getBean("systemRoleBS");
		IMenuBusinessService moduleService = (IMenuBusinessService) getBsFactory()
				.getFactory().getBean("menuBS");
		ActionMessages messages = new ActionMessages();
		String parentWrite = roleAccessForm.getParentWrite();
		String subWrite = roleAccessForm.getSubWrite();

		String[] pWrite = parentWrite.split("==");
		String[] sWrite = subWrite.split("==");
		moduleService.deleteMenu(new RoleMenuAccess(), "systemRole.id",
				roleAccessForm.getSystemId(), "long");
		List<ParentMenuManagement> parentList = (List<ParentMenuManagement>) session
				.getAttribute("parentMenuList");
		List<SubMenuManagement> subList = (List<SubMenuManagement>) session
				.getAttribute("subMenuList");
		if (parentList.size() > 0) {
			int i = 0, j = 0;
			List<RoleMenuAccess> accessList = new ArrayList<RoleMenuAccess>();
			Iterator<ParentMenuManagement> itr = parentList.iterator();
			while (itr.hasNext()) {
				ParentMenuManagement parentMenuManagement = new ParentMenuManagement();
				parentMenuManagement = itr.next();
				RoleMenuAccess userMenuAccess = new RoleMenuAccess();
				if (pWrite[i].equalsIgnoreCase("True")) {
					userMenuAccess.getSystemRole().setId(
							Long.parseLong(roleAccessForm.getSystemId()));
					userMenuAccess
							.setSubMenuManagement(new SubMenuManagement());
					userMenuAccess.setAccessType('W');
					accessList.add(userMenuAccess);
				}
				i++;
				if (subList.size() > 0) {
					Iterator<SubMenuManagement> itr1 = subList.iterator();
					while (itr1.hasNext()) {
						SubMenuManagement subMenuManagement = (SubMenuManagement) itr1
								.next();
						if (parentMenuManagement.getId() == subMenuManagement
								.getParentid().getId()) {
							userMenuAccess = new RoleMenuAccess();
							userMenuAccess.getSystemRole()
									.setId(Long.parseLong(roleAccessForm
											.getSystemId()));
							if (sWrite[j].equalsIgnoreCase("True")) {
								userMenuAccess
										.setSubMenuManagement(subMenuManagement);
								userMenuAccess.setAccessType('W');
								accessList.add(userMenuAccess);
							}
							j++;
							if (userMenuAccess.getSubMenuManagement().getId() != 0) {
								RoleMenuAccess roleMenuAccess = new RoleMenuAccess();
								roleMenuAccess.setSubMenuManagement(null);
								moduleService.saveRequirement(userMenuAccess);

							}
						}

					}
				}

			}

		}

		systemRoles = systemRoleService.getSystemRoles();
		request.setAttribute("SYSTEM_ROLES", systemRoles);
		List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
		FilterConditions filterConditions = new FilterConditions(
				new RoleMenuAccess(), "systemRole.id",
				roleAccessForm.getSystemId() + "", "long");
		List<RoleMenuAccess> menList = new ArrayList<RoleMenuAccess>();
		criteriaList.add(filterConditions);
		menList = moduleService.getRoleMenu(criteriaList);
		SystemRole systemRole = new SystemRole();
		populateRoleList(systemRole, menList, session);
		messages.add("menu_add_status", new ActionMessage(
				"menu.data.added.success"));
		saveMessages(request, messages);
		forward = mapping.findForward("edit");
		return forward;
	}

	public void populateRoleList(SystemRole systemRole,
			List<RoleMenuAccess> accessList, HttpSession session)
			throws Exception {

		List<RoleMenuAccess> accessModList = new ArrayList<RoleMenuAccess>();
		if (accessList.size() > 0) {
			Iterator<RoleMenuAccess> itr = accessList.iterator();
			while (itr.hasNext()) {
				RoleMenuAccess roleMenuAccess = itr.next();
				RoleMenuAccess userMenuAccess = new RoleMenuAccess();
				if (roleMenuAccess.getParentMenuManagement() == null) {
					userMenuAccess
							.setParentMenuManagement(new ParentMenuManagement());
				} else {

					userMenuAccess.setParentMenuManagement(roleMenuAccess
							.getParentMenuManagement());
				}

				if (roleMenuAccess.getSubMenuManagement() == null) {
					userMenuAccess
							.setSubMenuManagement(new SubMenuManagement());
				} else {

					userMenuAccess.setSubMenuManagement(roleMenuAccess
							.getSubMenuManagement());

				}

				userMenuAccess.setAccessType(roleMenuAccess.getAccessType());

				if (userMenuAccess.getParentMenuManagement() == null) {
					userMenuAccess
							.setParentMenuManagement(new ParentMenuManagement());
				}
				if (userMenuAccess.getSubMenuManagement() == null) {
					userMenuAccess
							.setSubMenuManagement(new SubMenuManagement());
				}

				accessModList.add(userMenuAccess);
			}
		}

		session.setAttribute("accessList", accessModList);

	}

}
