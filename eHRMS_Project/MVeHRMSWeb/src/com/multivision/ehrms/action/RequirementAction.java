package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.multivision.ehrms.action.form.EmployeeForm;
import com.multivision.ehrms.action.form.RequirementForm;
import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IRequirementBusinessService;

public class RequirementAction extends BaseDispatchAction {

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
			} else if (parameter.equalsIgnoreCase("add")) {
				forward = add(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("save")) {
				forward = save(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("edit")) {
				forward = edit(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("view")) {
				forward = view(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing requirement information");
		ActionForward forward = null;
		List<Requirement> reList = getRequirement();
		request.setAttribute("reqList", reList);
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add requirement details");
		ActionForward forward = null;
		RequirementForm requirementForm = (RequirementForm) form;
		clearFormValues(requirementForm);
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit requirement details");
		ActionForward forward = null;
		RequirementForm lForm = (RequirementForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Requirement requirement = fetchRequirement(Id);
		setFormValues(lForm, requirement);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display requirement details");
		ActionForward forward = null;
		RequirementForm requirementForm = (RequirementForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Requirement requirement = fetchRequirement(Id);
		setFormValues(requirementForm, requirement);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the requirement details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		RequirementForm lRequestForm = (RequirementForm) form;
		try {
			saveValues(lRequestForm);

			messages.add("requirement_add_status", new ActionMessage(
					"requirement.data.added.success"));
			saveMessages(request, messages);
			// empForm.setAction("save");
			logger.info("Saved the requirement details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("requirement_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("requirement_add_status", new ActionMessage(
					"requirement.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("requirement_add_status",
					new ActionMessage("employee.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying resignation screen to to mark employee resignation details");
		ActionForward forward = null;
		EmployeeForm empForm = (EmployeeForm) form;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
		}
		empForm.setAction("delete");
		empForm.setResignDate("");
		empForm.setResignReason("");
		empForm.setIsResigned('Y');
		forward = mapping.findForward("delete");
		return forward;
	}

	private List<Requirement> getRequirement() throws Exception {
		List<Requirement> reqList = new ArrayList<Requirement>();
		IRequirementBusinessService lService = (IRequirementBusinessService) getBsFactory()
				.getFactory().getBean("requirementBS");
		reqList = lService.getRequirement();
		return reqList;
	}

	private void clearFormValues(RequirementForm requirementForm) {
		requirementForm.setId(null);
		requirementForm.setRequirementId("");
		requirementForm.setClientName("");
		requirementForm.setClientDescription("");
		requirementForm.setClientDescription("");
		requirementForm.setUrl("");
		requirementForm.setPositionName("");
		requirementForm.setNoOfVancancy("");
		requirementForm.setEndDate("");
		requirementForm.setPositionStatus("");
		requirementForm.setMinimumQualification("");
		requirementForm.setOptionalRequirement("");
		requirementForm.setComments("");
		requirementForm.setStatus("Active");
		requirementForm.setLocation("");
		requirementForm.setSkillset("");
	}

	private void setFormValues(RequirementForm lForm, Requirement lRequest) {
		lForm.setId(lRequest.getId());
		lForm.setClientName(lRequest.getClientName());
		lForm.setRequirementId(lRequest.getRequirementId());
		lForm.setClientDescription(lRequest.getClientDescription());
		lForm.setUrl(lRequest.getUrl());
		lForm.setPositionName(lRequest.getPositionName());
		lForm.setNoOfVancancy(lRequest.getNoOfVancancy());
		lForm.setEndDate(lRequest.getEndDate());
		lForm.setPositionStatus(lRequest.getPositionStatus());
		lForm.setMinimumQualification(lRequest.getMinimumQualification());
		lForm.setOptionalRequirement(lRequest.getOptionalRequirement());
		lForm.setComments(lRequest.getComments());
		lForm.setStatus(lRequest.getStatus());
		lForm.setLocation(lRequest.getLocation());
		lForm.setSkillset(lRequest.getSkillset());

	}

	private void saveValues(RequirementForm requirementForm) throws Exception {
		Requirement requirement = saveFormValues(requirementForm);
		IRequirementBusinessService lService = (IRequirementBusinessService) getBsFactory()
				.getFactory().getBean("requirementBS");
		lService.saveRequirement(requirement);
	}

	private Requirement saveFormValues(RequirementForm lForm) throws Exception {
		Requirement requirement = new Requirement();
		requirement.setId(lForm.getId());
		requirement.setClientName(lForm.getClientName());
		requirement.setRequirementId(lForm.getRequirementId());
		requirement.setClientDescription(lForm.getClientDescription());
		requirement.setUrl(lForm.getUrl());
		requirement.setPositionName(lForm.getPositionName());
		requirement.setNoOfVancancy(lForm.getNoOfVancancy());
		requirement.setEndDate(lForm.getEndDate());
		requirement.setPositionStatus(lForm.getPositionStatus());
		requirement.setMinimumQualification(lForm.getMinimumQualification());
		requirement.setOptionalRequirement(lForm.getOptionalRequirement());
		requirement.setComments(lForm.getComments());
		requirement.setStatus(lForm.getStatus());
		requirement.setLocation(lForm.getLocation());
		requirement.setSkillset(lForm.getSkillset());
		return requirement;
	}

	private Requirement fetchRequirement(Long Id) throws Exception {
		Requirement requirement = null;
		IRequirementBusinessService lService = (IRequirementBusinessService) getBsFactory()
				.getFactory().getBean("requirementBS");
		requirement = lService.getRequirement(Id);
		return requirement;
	}

}
