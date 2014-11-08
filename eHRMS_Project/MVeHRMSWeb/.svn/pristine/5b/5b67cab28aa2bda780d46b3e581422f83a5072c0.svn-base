package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.FilterConditions;

import com.multivision.ehrms.business.Employees;

import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IEmployeeBusinessService;

public class HomeAction extends Action {

	private Logger logger = Logger.getRootLogger();

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
		if (request.getParameter("method") != null) {
			String parameter = request.getParameter("method");
			if (parameter.equalsIgnoreCase("list")) {
				forward = list(mapping, form, request, response);
			}
			if (parameter.equalsIgnoreCase("getList")) {
				forward = getList(mapping, form, request, response);
			}

		}
		return forward;
	}

	@SuppressWarnings("rawtypes")
	private ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing employee information");
		ActionForward forward = null;
		List employees = new ArrayList();
		String id = request.getParameter("id");
		IEmployeeBusinessService employeeService = (IEmployeeBusinessService) getBsFactory()
				.getFactory().getBean("employeeBS");
		List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
		FilterConditions filterConditions = new FilterConditions(
				new Employee(), "empId", id, "String");
		List<Employee> menList = new ArrayList<Employee>();
		criteriaList.add(filterConditions);
		menList = employeeService.getEmployeesList(criteriaList);
		request.setAttribute("employee", menList);
		request.setAttribute("EMPLOYEESDETAILS", employees);
		request.setAttribute("EMPLOYEES", null);
		forward = mapping.findForward("add");
		return forward;
	}

	@SuppressWarnings("rawtypes")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing employee information");
		ActionForward forward = null;
		List employeesList = new ArrayList();
		try {		
			Properties pr = new Properties(); 
			pr.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory"); 
			pr.put(Context.PROVIDER_URL,"t3://localhost:7001"); 

			InitialContext ic = new InitialContext(pr);
			Object objref = ic.lookup("EmployeeBean#com.multivision.ehrms.business.Employees");
			Employees employees = (Employees)objref;
			employeesList = employees.getCurrentMonthAnniversaryEmployees();
			
		} catch (Exception e1) {
		}
		if (employeesList.size() > 0) {

		}
		request.setAttribute("EMPLOYEES", employeesList);
		request.setAttribute("EMPLOYEESDETAILS", null);
		forward = mapping.findForward("list");
		return forward;
	}

}
