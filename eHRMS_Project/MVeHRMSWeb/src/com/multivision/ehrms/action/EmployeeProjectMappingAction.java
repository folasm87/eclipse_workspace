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

import com.multivision.ehrms.action.form.EmployeeProjectMappingForm;
import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.EmployeeProjectMapping;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.Project;
import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IEmployeeBusinessService;
import com.multivision.ehrms.service.business.interfaces.IEmployeeProjectMappingBusinessService;
import com.multivision.ehrms.service.business.interfaces.IProjectBusinessService;
import com.multivision.ehrms.service.business.interfaces.ISystemRoleBusinessService;

public class EmployeeProjectMappingAction extends BaseDispatchAction {

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
			} else if (parameter.equalsIgnoreCase("getProjects")) {
				forward = projects(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("add")) {
				forward = add(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("save")) {
				forward = save(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("edit")) {
				forward = edit(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("view")) {
				forward = view(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("update")) {
				forward = update(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward projects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing EmployeeProjectMapping information");
		ActionForward forward = null;
		request.getSession(false).setAttribute("PROJECTS", getProjects());
		request.getSession(false).setAttribute("EMPLOYEEPROJECTMAPING", null);
		forward = mapping.findForward("getProjects");
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing EmployeeProjectMapping information");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		List<EmployeeProjectMapping> employeeProjectmapping = getEmployeeProjectMapping(employeeProjectMappingForm
				.getProject().getId());
		if (employeeProjectmapping.isEmpty()) {

		} else {
			request.getSession(false).setAttribute("EMPLOYEEPROJECTMAPING",
					employeeProjectmapping);
		}
		if (employeeProjectmapping.size() == 0) {
			messages.add("employee_project_add_status", new ActionMessage(
					"label.not.found"));
			saveMessages(request, messages);
		}

		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add EmployeeProjectMapping details");
		ActionForward forward = null;
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		employeeProjectMappingForm.setAction("add");
		Long id = employeeProjectMappingForm.getProject().getId();
		IEmployeeProjectMappingBusinessService employeeProjectMappingService = (IEmployeeProjectMappingBusinessService) getBsFactory()
				.getFactory().getBean("employeeProjectMappingBS");

		clearFormValues(employeeProjectMappingForm);
		setProjectDetails(employeeProjectMappingForm, id);
		request.getSession(false).setAttribute("SYSTEM_ROLES",
				fetchSystemRoles());
		employeeProjectMappingForm.setAction("add");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = getEmployees();
		List<EmployeeProjectMapping> empProject = new ArrayList<EmployeeProjectMapping>();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
			FilterConditions filterConditions = new FilterConditions(
					new EmployeeProjectMapping(), "employee.id",
					employee.getId() + "", "long");
			FilterConditions filterConditions1 = new FilterConditions(
					new EmployeeProjectMapping(), "project.id", id + "", "long");
			criteriaList.add(filterConditions);
			criteriaList.add(filterConditions1);

			List<EmployeeProjectMapping> tmpList = employeeProjectMappingService
					.getEmployeeProjectList(criteriaList);
			if (!tmpList.isEmpty()) {
				empProject.add(tmpList.get(0));
				employeeList.remove(i);
			}

		}
		request.setAttribute("EMPLOYEEPROJECTMAPING", empProject);

		request.getSession(false).setAttribute("EMPLOYEES", employeeList);
		forward = mapping.findForward("add");
		return forward;
	}

	private void setProjectDetails(
			EmployeeProjectMappingForm employeeProjectMappingForm, Long id)
			throws Exception {
		Project project = fetchProject(id);
		employeeProjectMappingForm.getProject().setId(project.getId());
		employeeProjectMappingForm.getProject().setName(project.getName());
		employeeProjectMappingForm.getProject().setStartDate(
				project.getStartDate());
		employeeProjectMappingForm.getProject()
				.setEndDate(project.getEndDate());
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit EmployeeProjectMapping details");
		ActionForward forward = null;
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		EmployeeProjectMapping employeeProjectMapping = (EmployeeProjectMapping) fetchEmployeeProjectMapping(Id);
		request.getSession(false).setAttribute("SYSTEM_ROLES",
				fetchSystemRoles());
		setEmployeeDetails(employeeProjectMappingForm, Id,
				employeeProjectMapping);
		forward = mapping.findForward("edit");
		return forward;
	}

	private void setEmployeeDetails(
			EmployeeProjectMappingForm employeeProjectMappingForm, Long Id,
			EmployeeProjectMapping employeeProjectMapping) {
		employeeProjectMappingForm.setAction("edit");
		employeeProjectMappingForm.getEmployee().setId(
				employeeProjectMapping.getEmployee().getId());
		employeeProjectMappingForm.getEmployee().setName(
				employeeProjectMapping.getEmployee().getName());
		employeeProjectMappingForm.setId(Id);
		employeeProjectMappingForm.setStartDate(employeeProjectMapping
				.getStartDate());
		employeeProjectMappingForm.setEndDate(employeeProjectMapping
				.getEndDate());
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display EmployeeProjectMapping details");
		ActionForward forward = null;
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		EmployeeProjectMapping employeeProjectMapping = (EmployeeProjectMapping) fetchEmployeeProjectMapping(Id);
		setFormValues(employeeProjectMappingForm, employeeProjectMapping);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the EmployeeProjectMapping details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		try {
			String empIds[] = employeeProjectMappingForm.getEmpIds().split(",");
			String dates[] = employeeProjectMappingForm.getDates().split("~");
			IEmployeeProjectMappingBusinessService employeeProjectMappingService = (IEmployeeProjectMappingBusinessService) getBsFactory()
					.getFactory().getBean("employeeProjectMappingBS");
			EmployeeProjectMapping employeeProjectMapping = new EmployeeProjectMapping();
			for (int i = 0; i < empIds.length; i++) {
				employeeProjectMapping.getProject().setId(
						employeeProjectMappingForm.getProject().getId());
				employeeProjectMapping.getEmployee().setId(
						Long.parseLong(empIds[i]));
				String tmpDate[] = dates[i].split(",");
				employeeProjectMapping.setStartDate(tmpDate[0]);
				employeeProjectMapping.setEndDate(tmpDate[1]);
				employeeProjectMappingService
						.saveEmployeeProjectMapping(employeeProjectMapping);
			}

			List<EmployeeProjectMapping> employeeProjectmapping = getEmployeeProjectMapping(employeeProjectMappingForm
					.getProject().getId());
			if (employeeProjectmapping.isEmpty()) {

			} else {
				request.getSession(false).setAttribute("EMPLOYEEPROJECTMAPING",
						employeeProjectmapping);
			}

			messages.add("employee_project_add_status", new ActionMessage(
					"employee.project.data.added.success"));
			saveMessages(request, messages);
			employeeProjectMappingForm.setAction("save");
			logger.info("Saved the employee Project Mapping details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("employee_project_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("employee_project_add_status", new ActionMessage(
					"employee.project.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("employee_project_add_status",
					new ActionMessage(
							"employee.project.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the EmployeeProjectMapping details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("update");
		EmployeeProjectMappingForm employeeProjectMappingForm = (EmployeeProjectMappingForm) form;
		try {

			saveValues(employeeProjectMappingForm);
			messages.add("employee_add_status", new ActionMessage(
					"employee.data.added.success"));
			saveMessages(request, messages);
			employeeProjectMappingForm.setAction("save");
			logger.info("Saved the employee details");
			List<EmployeeProjectMapping> employeeProjectmapping = getEmployeeProjectMapping(employeeProjectMappingForm
					.getProject().getId());
			request.getSession(false).setAttribute("EMPLOYEEPROJECTMAPING",
					employeeProjectmapping);

		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("employee_project_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("employee_project_add_status", new ActionMessage(
					"employee.project.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("employee_project_add_status",
					new ActionMessage(
							"employee.project.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private List<EmployeeProjectMapping> getEmployeeProjectMapping(Long id)
			throws Exception {
		List<EmployeeProjectMapping> employeeProjectMapping = new ArrayList<EmployeeProjectMapping>();
		IEmployeeProjectMappingBusinessService employeeProjectMappingService = (IEmployeeProjectMappingBusinessService) getBsFactory()
				.getFactory().getBean("employeeProjectMappingBS");
		employeeProjectMapping = employeeProjectMappingService
				.getEmployeeProjectMappingByProject(id);
		return employeeProjectMapping;
	}

	private void clearFormValues(
			EmployeeProjectMappingForm employeeProjectMappingForm) {
		employeeProjectMappingForm.setDates("");
	}

	private void setFormValues(
			EmployeeProjectMappingForm employeeProjectMappingForm,
			EmployeeProjectMapping employeeProjectMaping) {
		employeeProjectMappingForm.setId(employeeProjectMaping.getId());

	}

	private void saveValues(
			EmployeeProjectMappingForm employeeProjectMappingForm)
			throws Exception {
		EmployeeProjectMapping employeeProjectMapping = saveFormValues(employeeProjectMappingForm);
		IEmployeeProjectMappingBusinessService employeeProjectMappingService = (IEmployeeProjectMappingBusinessService) getBsFactory()
				.getFactory().getBean("employeeProjectMappingBS");
		employeeProjectMappingService
				.updateEmployeeProjectMapping(employeeProjectMapping);
	}

	private EmployeeProjectMapping saveFormValues(
			EmployeeProjectMappingForm employeeProjectMappingForm)
			throws Exception {
		EmployeeProjectMapping employeeProjectMapping = new EmployeeProjectMapping();
		if (!employeeProjectMappingForm.getAction().equalsIgnoreCase("add")) {
			employeeProjectMapping.setId(employeeProjectMappingForm.getId());
		}
		employeeProjectMapping.getProject().setId(
				employeeProjectMappingForm.getProject().getId());
		employeeProjectMapping.setStartDate(employeeProjectMappingForm
				.getStartDate());
		employeeProjectMapping.setEndDate(employeeProjectMappingForm
				.getEndDate());
		employeeProjectMapping.getEmployee().setId(
				employeeProjectMappingForm.getEmployee().getId());
		return employeeProjectMapping;
	}

	private EmployeeProjectMapping fetchEmployeeProjectMapping(Long Id)
			throws Exception {
		EmployeeProjectMapping employeeProjectMapping = new EmployeeProjectMapping();
		IEmployeeProjectMappingBusinessService employeeService = (IEmployeeProjectMappingBusinessService) getBsFactory()
				.getFactory().getBean("employeeProjectMappingBS");
		employeeProjectMapping = employeeService.getEmployeeProjectMapping(Id);
		return employeeProjectMapping;
	}

	private List<SystemRole> fetchSystemRoles() throws Exception {
		List<SystemRole> systemRoles = new ArrayList<SystemRole>();
		ISystemRoleBusinessService systemRoleService = (ISystemRoleBusinessService) getBsFactory()
				.getFactory().getBean("systemRoleBS");
		systemRoles = systemRoleService.getSystemRoles();
		return systemRoles;
	}

	private List<Employee> getEmployees() throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		IEmployeeBusinessService employeeService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		employees = employeeService.getEmployees();
		return employees;
	}

	private List<Project> getProjects() throws Exception {
		List<Project> projects = new ArrayList<Project>();
		IProjectBusinessService employeeService = (IProjectBusinessService) getBsFactory()
				.getFactory().getBean("projectBS");
		projects = employeeService.getProjects();
		return projects;
	}

	private Project fetchProject(Long Id) throws Exception {
		Project project = null;
		IProjectBusinessService projectService = (IProjectBusinessService) getBsFactory()
				.getFactory().getBean("projectBS");
		project = projectService.getProject(Id);
		return project;
	}

}
