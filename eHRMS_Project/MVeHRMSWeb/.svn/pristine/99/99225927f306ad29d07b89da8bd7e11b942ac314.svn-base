package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.EmployeeProjectMapping;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.business.interfaces.IEmployeeProjectMappingBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IEmployeeProjectMappingDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeProjectMappingBS")
public class EmployeeProjectMappingBusinessService implements IEmployeeProjectMappingBusinessService{

	@Override
	public List<EmployeeProjectMapping> getEmployeeProjectMappingByProject(Long id)
			throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		return employeeDataService.getEmployeeProjectMappingByProject(id);
	}

	@Override
	public void saveEmployeeProjectMapping(
			EmployeeProjectMapping employeeProjectMapping) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		employeeDataService.saveEmployeeProjectMapping(employeeProjectMapping);
	}

	@Override
	public EmployeeProjectMapping getEmployeeProjectMapping(Long Id)
			throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		return employeeDataService.getEmployeeProjectMapping(Id);
	}

	@Override
	public void deleteEmployeeProjectMapping(
			Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		employeeDataService.deleteEmployeeProjectMapping(Id);
		
	}

	@Override
	public void updateEmployeeProjectMapping(
			EmployeeProjectMapping employeeProjectMapping) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		employeeDataService.updateEmployeeProjectMapping(employeeProjectMapping);
			
	}
	
	public List<EmployeeProjectMapping> getEmployeeProjectList(List<FilterConditions> criteriaList) throws Exception {
		
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeProjectMappingDataService employeeDataService = (IEmployeeProjectMappingDataService) dsFactory
				.getFactory().getBean("employeeProjectMappingDS");
		return employeeDataService.getEmployeeProjectList(criteriaList);
		
	}

}
