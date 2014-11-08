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

import com.multivision.ehrms.action.form.LeaveRequestForm;
import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.LeaveRequest;
import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.ILeaveRequestBusinessService;

public class LeaveRequestAction extends BaseDispatchAction {

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
		logger.info("Listing Leave Request information");
		ActionForward forward = null;
		LeaveRequestForm leaveRequestForm = (LeaveRequestForm) form;
		ActionMessages messages = new ActionMessages();
		SuperUser suser = (SuperUser) request.getSession(false).getAttribute(
				"user");
		leaveRequestForm.setUserType("");
		if (suser.getSystemRole().getId() == 3) {
			leaveRequestForm.setUserType("HR");
		}
		if (suser.getEmployee() != null && suser.getEmployee().getId() != 0) {
			leaveRequestForm.setType('E');
			Long LoggedUserEmployeeId = suser.getEmployee().getId();
			List<LeaveRequest> leaveRequest = getLeaveRequest(LoggedUserEmployeeId);
			request.setAttribute("leaveRequest", leaveRequest);
		} else {
			leaveRequestForm.setType('A');
			messages.add("leave_add_status", new ActionMessage(
					"leave.previllage"));
			saveMessages(request, messages);
		}
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add leave Request details");
		ActionForward forward = null;
		LeaveRequestForm leaveRequestForm = (LeaveRequestForm) form;
		clearFormValues(leaveRequestForm);
		SuperUser suser = (SuperUser) request.getSession(false).getAttribute(
				"user");
		Long LoggedUserEmployeeId = suser.getEmployee().getId();
		leaveRequestForm.getEmployee().setId(LoggedUserEmployeeId);
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit leave Request details");
		ActionForward forward = null;
		LeaveRequestForm lForm = (LeaveRequestForm) form;
		// SuperUser suser = (SuperUser) request.getSession(false).getAttribute(
		// "user");
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		LeaveRequest leaveRequest = fetchLeaveRequest(Id);
		setFormValues(lForm, leaveRequest);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display leave Request details");
		ActionForward forward = null;
		LeaveRequestForm leaveRequestForm = (LeaveRequestForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		LeaveRequest leaveRequest = fetchLeaveRequest(Id);
		setFormValues(leaveRequestForm, leaveRequest);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the leave request details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		LeaveRequestForm lRequestForm = (LeaveRequestForm) form;
		try {
			saveValues(lRequestForm, request);
			messages.add("leave_add_status", new ActionMessage(
					"leave.data.added.success"));
			saveMessages(request, messages);
			logger.info("Saved the leave Requesst details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("leave_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("leave_add_status", new ActionMessage(
					"leaverequest.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("leave_add_status",
					new ActionMessage(
							"leaverequest.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private List<LeaveRequest> getLeaveRequest(Long loggedInUserId)
			throws Exception {
		List<LeaveRequest> leaveRequest = new ArrayList<LeaveRequest>();
		ILeaveRequestBusinessService lService = (ILeaveRequestBusinessService) getBsFactory()
				.getFactory().getBean("leaveRequestBS");
		leaveRequest = lService.getLeaveRequests(loggedInUserId);
		return leaveRequest;
	}

	private void clearFormValues(LeaveRequestForm leaveRequestForm) {
		leaveRequestForm.setStatus("PENDING");
		leaveRequestForm.setFromDate("");
		leaveRequestForm.setToDate("");
		leaveRequestForm.setLeaveType("");
		leaveRequestForm.setNoOfDays("");
		leaveRequestForm.setReason("");
		leaveRequestForm.setEmployee(new Employee());
	}

	private void setFormValues(LeaveRequestForm lForm, LeaveRequest lRequest) {
		lForm.setId(lRequest.getId());
		lForm.setFromDate(lRequest.getFromDate());
		lForm.setToDate(lRequest.getToDate());
		lForm.setReason(lRequest.getReason());
		lForm.getEmployee().setId(lRequest.getEmployee().getId());
		lForm.setLeaveType(lRequest.getLeaveType());
		lForm.setNoOfDays(lRequest.getNoOfDays());
		lForm.setStatus(lRequest.getStatus());
	}

	private void saveValues(LeaveRequestForm leaveRequestForm,
			HttpServletRequest request) throws Exception {
		LeaveRequest leaveRequest = saveFormValues(leaveRequestForm, request);
		ILeaveRequestBusinessService lService = (ILeaveRequestBusinessService) getBsFactory()
				.getFactory().getBean("leaveRequestBS");
		lService.saveLeaveRequest(leaveRequest);
	}

	private LeaveRequest saveFormValues(LeaveRequestForm leaveRequestForm,
			HttpServletRequest request) throws Exception {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setStatus(leaveRequestForm.getStatus());
		leaveRequest.setId(leaveRequestForm.getId());
		leaveRequest.setLeaveType(leaveRequestForm.getLeaveType());
		leaveRequest.setFromDate(leaveRequestForm.getFromDate());
		leaveRequest.setToDate(leaveRequestForm.getToDate());
		leaveRequest.setReason(leaveRequestForm.getReason());
		leaveRequest.setNoOfDays(leaveRequestForm.getNoOfDays());
		leaveRequest.getEmployee().setId(
				((SuperUser) request.getSession(false).getAttribute("user"))
						.getEmployee().getId());
		return leaveRequest;
	}

	private LeaveRequest fetchLeaveRequest(Long Id) throws Exception {
		LeaveRequest leaveRequest = null;
		ILeaveRequestBusinessService lService = (ILeaveRequestBusinessService) getBsFactory()
				.getFactory().getBean("leaveRequestBS");
		leaveRequest = lService.getLeaveRequest(Id);
		return leaveRequest;
	}

}
