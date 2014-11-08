package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.EmployeeProjectMapping;
import com.multivision.ehrms.business.FilterConditions;

public interface IEmployeeProjectMappingDataService {
	
	public List<EmployeeProjectMapping> getEmployeeProjectMappingByProject(Long id) throws Exception;

	public void saveEmployeeProjectMapping(EmployeeProjectMapping employeeProjectMapping) throws Exception;
	
	public void deleteEmployeeProjectMapping(Long Id) throws Exception;
	
	public void updateEmployeeProjectMapping(EmployeeProjectMapping employeeProjectMapping) throws Exception;
	
	public EmployeeProjectMapping getEmployeeProjectMapping(Long Id) throws Exception;
	
	public List<EmployeeProjectMapping> getEmployeeProjectList(List<FilterConditions> criteriaList) throws Exception;

}
