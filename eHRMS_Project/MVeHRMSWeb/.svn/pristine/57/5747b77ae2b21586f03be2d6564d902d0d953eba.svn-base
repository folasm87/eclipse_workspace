package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.business.interfaces.IEmployeeBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IEmployeeDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeBS")
public class EmployeeBusinessService implements IEmployeeBusinessService {

	public List<Employee> getEmployees() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeDataService employeeDataService = (IEmployeeDataService) dsFactory
				.getFactory().getBean("employeeDS");
		return employeeDataService.getEmployees();
	}

	public Long saveEmployee(Employee employee) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeDataService employeeDataService = (IEmployeeDataService) dsFactory
				.getFactory().getBean("employeeDS");
		return employeeDataService.saveEmployee(employee);
	}

	public Employee getEmployee(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeDataService employeeDataService = (IEmployeeDataService) dsFactory
				.getFactory().getBean("employeeDS");
		return employeeDataService.getEmployee(Id);
	}

	public List<Employee> getEmployeesList(List<FilterConditions> criteriaList)
			throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeDataService employeeDataService = (IEmployeeDataService) dsFactory
				.getFactory().getBean("employeeDS");
		return employeeDataService.getEmployeesList(criteriaList);

	}
}
