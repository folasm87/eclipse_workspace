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

import com.multivision.ehrms.action.form.RequirementForm;
import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.email.Emailer;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IApplicantBusinessService;
import com.multivision.ehrms.service.business.interfaces.IRequirementBusinessService;
import com.multivision.ehrms.util.PropertyKeyReader;

public class JobSearchAction extends BaseDispatchAction {

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
			} else if (parameter.equalsIgnoreCase("search")) {
				forward = search(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("apply")) {
				forward = apply(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing jobserach information");
		RequirementForm requirementForm = (RequirementForm) form;
		ActionForward forward = null;
		String position = requirementForm.getPositionName();
		String location = requirementForm.getLocation();
		String skill = requirementForm.getSkillset();
		String employer = requirementForm.getClientName();
		ActionMessages messages = new ActionMessages();
		List<Requirement> reList = searchRequirement(position, location, skill,
				employer);
		request.setAttribute("reqList", reList);
		if (reList.size() == 0) {
			messages.add("jobsearch_add_status", new ActionMessage(
					"label.not.found"));
			saveMessages(request, messages);
		}
		forward = mapping.findForward("search");
		return forward;
	}

	public ActionForward apply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Apply for Requirement");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		String reqId = request.getParameter("reqId");
		SuperUser user = (SuperUser) request.getSession().getAttribute("user");
		if (user != null) {
			IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
					.getFactory().getBean("applicantBS");
			List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
			FilterConditions filterConditions = new FilterConditions(
					new Applicant(), "username", user.getUsername(), "String");
			List<Applicant> appList = new ArrayList<Applicant>();
			criteriaList.add(filterConditions);
			appList = lService.getApplicants(criteriaList);
			if (appList.size() > 0) {
				try {
					Applicant applicant = appList.get(0);
					sendMail(request, applicant, reqId);
					messages.add("job_apply", new ActionMessage(
							"job.apply.success"));
					saveMessages(request, messages);
				} catch (javax.mail.MessagingException msgException) {
					logger.debug(msgException);
					messages.add("jobsearch_add_status", new ActionMessage(
							"jobsearch.data.added.email.failed"));
					saveMessages(request, messages);
				}
			}
		}

		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing jobserach information");
		ActionForward forward = null;
		RequirementForm requirementForm = (RequirementForm) form;
		SuperUser suser = (SuperUser) request.getSession(false).getAttribute(
				"user");
		requirementForm.setType("A");
		if (suser.getApplicant() == null) {
			requirementForm.setType("E");
		}
		forward = mapping.findForward("list");
		return forward;
	}

	private List<Requirement> searchRequirement(String position,
			String location, String skill, String employer) throws Exception {
		List<Requirement> requirList = new ArrayList<Requirement>();
		IRequirementBusinessService lService = (IRequirementBusinessService) getBsFactory()
				.getFactory().getBean("requirementBS");
		requirList = lService.JobSearch(position, location, skill, employer);
		return requirList;
	}

	private void sendMail(HttpServletRequest request, Applicant applicant,
			String reqId) throws Exception {

		StringBuffer emailContent = new StringBuffer();

		PropertyKeyReader reader = new PropertyKeyReader();
		String newLine = System.getProperty("line.separator");
		String hello = reader.getKey("mail.wish");

		emailContent.append(hello);
		emailContent.append(" ");
		emailContent.append(applicant.getName());
		emailContent.append(newLine);
		emailContent.append(newLine);

		String welcome = reader.getKey("mail.welcome");
		emailContent.append(welcome);
		emailContent.append(newLine);
		emailContent.append(newLine);

		String userName = "You applied the following jobID" + reqId;
		emailContent.append(userName);
		emailContent.append(newLine);
		emailContent.append(newLine);

		new Emailer().postMail(applicant.getEmail(), emailContent.toString(),
				welcome);
	}

}
