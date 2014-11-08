package com.multivision.ehrms.action;

import java.rmi.RemoteException;
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
import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.email.Emailer;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IEmployeeBusinessService;
import com.multivision.ehrms.service.business.interfaces.ISystemRoleBusinessService;
import com.multivision.ehrms.service.business.interfaces.IUserBusinessService;
import com.multivision.ehrms.util.PropertyKeyReader;
import com.multivision.webservice.EmployeeAnniversaryProxy;

public class EmployeeAction extends BaseDispatchAction {

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
			} else if (parameter.equalsIgnoreCase("delete")) {
				forward = delete(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("resign")) {
				forward = resign(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing employee information");
		ActionForward forward = null;
		List<Employee> employees = getEmployees();
		request.setAttribute("EMPLOYEES", employees);
		request.setAttribute("ANNIV_EMP", getCurrentMonthAnivEmployess());
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add employee details");
		ActionForward forward = null;
		EmployeeForm empForm = (EmployeeForm) form;
		empForm.setAction("add");
		clearFormValues(empForm);
		request.getSession(false).setAttribute("SYSTEM_ROLES",
				fetchSystemRoles());
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit employee details");
		ActionForward forward = null;
		EmployeeForm empForm = (EmployeeForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Employee employee = fetchEmployee(Id);
		request.getSession(false).setAttribute("SYSTEM_ROLES",
				fetchSystemRoles());
		empForm.setAction("edit");
		setFormValues(empForm, employee);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display employee details");
		ActionForward forward = null;
		EmployeeForm empForm = (EmployeeForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Employee employee = fetchEmployee(Id);
		setFormValues(empForm, employee);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the employee details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		EmployeeForm empForm = (EmployeeForm) form;
		try {
			Long employeeId = saveValues(empForm);
			// if (empForm.getAction().equalsIgnoreCase("add")) {
			saveUserDetails(empForm, employeeId);
			sendMail(request, empForm);
			// }
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.success"));
			saveMessages(request, messages);
			empForm.setAction("save");
			logger.info("Saved the employee details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("employee_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (javax.mail.MessagingException msgException) {
			logger.debug(msgException);
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.email.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("employee_add_status",
					new ActionMessage("employee.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private void saveUserDetails(EmployeeForm empForm, Long employeeId)
			throws Exception {
		IUserBusinessService userService = (IUserBusinessService) getBsFactory()
				.getFactory().getBean("userBS");
		SuperUser superUser = new SuperUser();
		superUser.setUsername(empForm.getEmpId());
		superUser.setPassword(empForm.getEmpId() + "password");
		// superUser
		// .setPassword(Encrypter.encrypt(empForm.getEmpId() + "password"));
		superUser.setSystemRole(empForm.getRole());
		superUser.getEmployee().setId(employeeId);
		// superUser.getApplicant().setId(null);
		superUser.setApplicant(null);
		userService.saveUser(superUser);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying resignation screen to to mark employee resignation details");
		ActionForward forward = null;
		EmployeeForm empForm = (EmployeeForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Employee employee = fetchEmployee(Id);
		// Except the resignation details retain the existing employee
		// information as it is.
		setFormValues(empForm, employee);
		empForm.setAction("delete");
		empForm.setResignDate("");
		empForm.setResignReason("");
		empForm.setIsResigned('Y');
		forward = mapping.findForward("delete");
		return forward;
	}

	public ActionForward resign(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Updating employee resignation details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("resign");
		EmployeeForm empForm = (EmployeeForm) form;
		try {
			saveValues(empForm);
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.success"));
			saveMessages(request, messages);
			empForm.setAction("save");
			logger.info("Updated employee resignation details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("employee_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("employee_add_status",
					new ActionMessage("employee.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	/**
	 * This object invokes the Webservice component to get the list of employee
	 * names who celebrates their anniversary in current month
	 * 
	 * @return
	 */
	private String getCurrentMonthAnivEmployess() {
		String employeeNameInString = "";
		try {
			/*
			 * Invokes the proxy of the web service component and this proxy is
			 * the local representation of the webservice component and it is
			 * generated from WSDL
			 */
			String[] employeeNames = new EmployeeAnniversaryProxy()
					.getCurrentMonthAnniversaryEmployeesName();
			for (int tmp = 0; tmp < employeeNames.length; tmp++) {
				employeeNameInString = employeeNameInString + "     "
						+ employeeNames[tmp];
			}
		} catch (RemoteException re) {
			re.printStackTrace();
		}
		return employeeNameInString;
	}

	private List<Employee> getEmployees() throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		IEmployeeBusinessService employeeService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		employees = employeeService.getEmployees();
		return employees;
	}

	private void clearFormValues(EmployeeForm employeeForm) {
		employeeForm.setAddress("");
		employeeForm.setBenefits("");
		employeeForm.setClientInfo("");
		employeeForm.setCompensation("");
		employeeForm.setDob("");
		employeeForm.setEmpId("");
		employeeForm.setEmpType('P');
		employeeForm.setImmigirationStatus("");
		employeeForm.setIsResigned('N');
		employeeForm.setJobTitle("");
		employeeForm.setJoinDate("");
		employeeForm.setMobile("");
		employeeForm.setName("");
		employeeForm.setPersonalEmailId("");
		employeeForm.setResignDate("");
		employeeForm.setResignReason("");
		employeeForm.setVendorName("");
		employeeForm.setWorkEmailId("");
		employeeForm.setWorkphone("");
		// By default the role will be set as Employee
		employeeForm.getRole().setId(5L);
	}

	private void setFormValues(EmployeeForm employeeForm, Employee employee) {
		employeeForm.setId(employee.getId());
		employeeForm.setAddress(employee.getAddress());
		employeeForm.setBenefits(employee.getBenefits());
		employeeForm.setClientInfo(employee.getClientInfo());
		employeeForm.setCompensation(employee.getCompensation());
		employeeForm.setDob(employee.getDob());
		employeeForm.setEmpId(employee.getEmpId());
		employeeForm.setEmpType(employee.getEmpType());
		employeeForm.setImmigirationStatus(employee.getImmigirationStatus());
		employeeForm.setIsResigned(employee.getIsResigned());
		employeeForm.setJobTitle(employee.getJobTitle());
		employeeForm.setJoinDate(employee.getJoinDate());
		employeeForm.setMobile(employee.getMobile());
		employeeForm.setName(employee.getName());
		employeeForm.setPersonalEmailId(employee.getPersonalEmailId());
		employeeForm.setResignDate(employee.getResignDate());
		employeeForm.setResignReason(employee.getResignReason());
		employeeForm.setVendorName(employee.getVendorName());
		employeeForm.setWorkEmailId(employee.getWorkEmailId());
		employeeForm.setWorkphone(employee.getWorkphone());
		employeeForm.getRole().setId(employee.getRole().getId());
		employeeForm.getRole().setName(employee.getRole().getName());
	}

	private Long saveValues(EmployeeForm employeeForm) throws Exception {
		Employee employee = saveFormValues(employeeForm);
		IEmployeeBusinessService employeeService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		Long employeeId = employeeService.saveEmployee(employee);
		return employeeId;
	}

	private Employee saveFormValues(EmployeeForm employeeForm) throws Exception {
		Employee employee = new Employee();
		employee.setAddress(employeeForm.getAddress());
		employee.setBenefits(employeeForm.getBenefits());
		employee.setClientInfo(employeeForm.getClientInfo());
		employee.setCompensation(employeeForm.getCompensation());
		employee.setDob(employeeForm.getDob());
		employee.setEmpId(employeeForm.getEmpId());
		employee.setEmpType(employeeForm.getEmpType());
		if (!employeeForm.getAction().equalsIgnoreCase("add")) {
			employee.setId(employeeForm.getId());
		}
		employee.setImmigirationStatus(employeeForm.getImmigirationStatus());
		employee.setIsResigned(employeeForm.getIsResigned());
		employee.setJobTitle(employeeForm.getJobTitle());
		employee.setJoinDate(employeeForm.getJoinDate());
		employee.setMobile(employeeForm.getMobile());
		employee.setName(employeeForm.getName());
		employee.setPersonalEmailId(employeeForm.getPersonalEmailId());
		employee.setResignDate(employeeForm.getResignDate());
		employee.setResignReason(employeeForm.getResignReason());
		employee.getRole().setId(employeeForm.getRole().getId());
		employee.setVendorName(employeeForm.getVendorName());
		employee.setWorkEmailId(employeeForm.getWorkEmailId());
		employee.setWorkphone(employeeForm.getWorkphone());
		return employee;
	}

	private List<SystemRole> fetchSystemRoles() throws Exception {
		List<SystemRole> systemRoles = new ArrayList<SystemRole>();
		ISystemRoleBusinessService systemRoleService = (ISystemRoleBusinessService) getBsFactory()
				.getFactory().getBean("systemRoleBS");
		systemRoles = systemRoleService.getSystemRoles();
		return systemRoles;
	}

	private Employee fetchEmployee(Long Id) throws Exception {
		Employee employee = null;
		IEmployeeBusinessService employeeService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		employee = employeeService.getEmployee(Id);
		return employee;
	}

	private void sendMail(HttpServletRequest request, EmployeeForm employeeForm)
			throws Exception {

		String toEmail = employeeForm.getPersonalEmailId();
		String name = employeeForm.getName();

		StringBuffer emailContent = new StringBuffer();

		PropertyKeyReader reader = new PropertyKeyReader();
		String newLine = System.getProperty("line.separator");
		String hello = reader.getKey("mail.wish");

		emailContent.append(hello);
		emailContent.append(" ");
		emailContent.append(name);
		emailContent.append(newLine);
		emailContent.append(newLine);

		String welcome = reader.getKey("mail.welcome");
		emailContent.append(welcome);
		emailContent.append(newLine);
		emailContent.append(newLine);

		String userName = "UserName";
		emailContent.append(userName);
		emailContent.append(newLine);
		emailContent.append(newLine);

		emailContent.append(employeeForm.getEmpId());
		emailContent.append(newLine);
		emailContent.append(newLine);

		String passWord = "PassWord";
		emailContent.append(passWord);
		emailContent.append(newLine);
		emailContent.append(newLine);

		emailContent.append(employeeForm.getEmpId() + "password");
		emailContent.append(newLine);
		emailContent.append(newLine);

		String thanks = reader.getKey("mail.thanks");
		emailContent.append(thanks);
		emailContent.append(newLine);

		String management = reader.getKey("mail.management");
		emailContent.append(management);
		emailContent.append(newLine);

		new Emailer().postMail(toEmail, emailContent.toString(), welcome);
	}
}
