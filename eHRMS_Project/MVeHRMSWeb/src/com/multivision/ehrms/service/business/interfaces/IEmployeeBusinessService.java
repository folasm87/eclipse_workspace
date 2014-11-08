package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.FilterConditions;

public interface IEmployeeBusinessService {

	public List<Employee> getEmployees() throws Exception;

	public Long saveEmployee(Employee employee) throws Exception;

	public Employee getEmployee(Long Id) throws Exception;

	public List<Employee> getEmployeesList(List<FilterConditions> criteriaList)
			throws Exception;

}
