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

import com.multivision.ehrms.action.form.EmployeeShiftTimeForm;
import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.EmployeeShiftTime;
import com.multivision.ehrms.business.Project;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IEmployeeBusinessService;
import com.multivision.ehrms.service.business.interfaces.IEmployeeShiftTimeBusinessService;
import com.multivision.ehrms.service.business.interfaces.IProjectBusinessService;

public class EmployeeShiftTimeAction extends BaseDispatchAction {

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
		logger.info("Listing employee Shift Timeing information");
		ActionForward forward = null;
		List<EmployeeShiftTime> employeesShift = getEmployeeShiftTime();
		request.setAttribute("EmloyeeShift", employeesShift);
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add employee Shift Timeing details");
		ActionForward forward = null;
		EmployeeShiftTimeForm empForm = (EmployeeShiftTimeForm) form;
		clearFormValues(empForm);
		request.getSession(false).setAttribute("EmployeeList", fetchEmployee());
		request.getSession(false).setAttribute("ProjectList", fetchProject());
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit employee Shift Timeing details");
		ActionForward forward = null;
		EmployeeShiftTimeForm empForm = (EmployeeShiftTimeForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		EmployeeShiftTime employeeShiftTime = fetchEmployeeShifTime(Id);
		request.getSession(false).setAttribute("EmployeeList", fetchEmployee());
		request.getSession(false).setAttribute("ProjectList", fetchProject());
		setFormValues(empForm, employeeShiftTime);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display employee Shift Timeing details");
		ActionForward forward = null;
		EmployeeShiftTimeForm empForm = (EmployeeShiftTimeForm) form;
		request.getSession(false).setAttribute("EmployeeList", fetchEmployee());
		request.getSession(false).setAttribute("ProjectList", fetchProject());
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		EmployeeShiftTime employee = fetchEmployeeShifTime(Id);
		setFormValues(empForm, employee);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the employee Shift Timeing details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		EmployeeShiftTimeForm empForm = (EmployeeShiftTimeForm) form;
		try {
			saveValues(empForm);
			messages.add("employee_shift_add_status", new ActionMessage(
					"employeeShift.data.added.success"));
			saveMessages(request, messages);
			logger.info("Saved the employee details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("employee_shift_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("employee_shift_add_status", new ActionMessage(
					"employeeShift.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("employee_shift_add_status",
					new ActionMessage(
							"employeeShift.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private List<EmployeeShiftTime> getEmployeeShiftTime() throws Exception {
		List<EmployeeShiftTime> employeesShift = new ArrayList<EmployeeShiftTime>();
		IEmployeeShiftTimeBusinessService employeeService = (IEmployeeShiftTimeBusinessService) getBsFactory()
				.getFactory().getBean("employeeShiftBS");
		employeesShift = employeeService.getEmployeeShiftTime();
		return employeesShift;
	}

	private void clearFormValues(EmployeeShiftTimeForm employeeForm) {

		employeeForm.setEmployee(new Employee());
		employeeForm.setProject(new Project());
		employeeForm.setDate("");
		employeeForm.setHours("");
		employeeForm.setJobDone("");
		employeeForm.setRemarks("");

	}

	private void setFormValues(EmployeeShiftTimeForm employeeShForm,
			EmployeeShiftTime employeeSTime) {

		employeeShForm.setId(employeeSTime.getId());
		employeeShForm.getEmployee().setId(employeeSTime.getEmployee().getId());
		employeeShForm.getProject().setId(employeeSTime.getProject().getId());
		employeeShForm.setDate(employeeSTime.getDate());
		employeeShForm.setHours(employeeSTime.getHours());
		employeeShForm.setJobDone(employeeSTime.getJobDone());
		employeeShForm.setRemarks(employeeSTime.getRemarks());

	}

	private void saveValues(EmployeeShiftTimeForm employeeForm)
			throws Exception {
		EmployeeShiftTime employeeShiftTime = saveFormValues(employeeForm);
		IEmployeeShiftTimeBusinessService employeeService = (IEmployeeShiftTimeBusinessService) getBsFactory()
				.getFactory().getBean("employeeShiftBS");
		employeeService.saveEmployeeShiftTime(employeeShiftTime);
	}

	private EmployeeShiftTime saveFormValues(EmployeeShiftTimeForm employeeSTime)
			throws Exception {
		EmployeeShiftTime employee = new EmployeeShiftTime();
		employee.setId(employeeSTime.getId());
		employee.getEmployee().setId(employeeSTime.getEmployee().getId());
		employee.getProject().setId(employeeSTime.getProject().getId());
		employee.setDate(employeeSTime.getDate());
		employee.setHours(employeeSTime.getHours());
		employee.setJobDone(employeeSTime.getJobDone());
		employee.setRemarks(employeeSTime.getRemarks());
		return employee;
	}

	private List<Employee> fetchEmployee() throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		IEmployeeBusinessService eService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		employees = eService.getEmployees();
		return employees;
	}

	private List<Project> fetchProject() throws Exception {
		List<Project> employees = new ArrayList<Project>();
		IProjectBusinessService eService = (IProjectBusinessService) getBsFactory()
				.getFactory().getBean("projectBS");
		employees = eService.getProjects();
		return employees;
	}

	private EmployeeShiftTime fetchEmployeeShifTime(Long Id) throws Exception {
		EmployeeShiftTime employeeShiftTime = null;
		IEmployeeShiftTimeBusinessService employeeService = (IEmployeeShiftTimeBusinessService) getBsFactory()
				.getFactory().getBean("employeeShiftBS");
		employeeShiftTime = employeeService.getEmployeeShiftTime(Id);
		return employeeShiftTime;
	}

}
