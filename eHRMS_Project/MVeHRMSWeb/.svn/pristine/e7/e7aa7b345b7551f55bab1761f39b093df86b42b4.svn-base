package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.data.interfaces.IEmployeeDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeDS")
public class EmployeeDataService extends BaseDataService implements
		IEmployeeDataService {

	/**
	 * Retrieve the active employees always
	 */
	public List<Employee> getEmployees() throws Exception {
		return getDataRetriever().retrieveByCriteria(new Employee(),
				"isResigned", "N", "char");
	}

	/**
	 * Save the supplied employee information
	 */
	public Long saveEmployee(Employee employee) throws Exception {
		return (Long) getDataModifier().updateRecord(employee);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public Employee getEmployee(Long Id) throws Exception {
		return (Employee) getDataRetriever().retrieveByKey(new Employee(),
				Id.toString());
	}

	public List<Employee> getEmployeesList(List<FilterConditions> criteriaList)
			throws Exception {
		return getDataRetriever().retrieveByCriteria(criteriaList);
	}
}
