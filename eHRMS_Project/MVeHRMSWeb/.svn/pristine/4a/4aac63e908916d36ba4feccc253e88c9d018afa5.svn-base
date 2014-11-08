package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.EmployeeProjectMapping;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.data.interfaces.IEmployeeProjectMappingDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeProjectMappingDS")
public class EmployeeProjectMappingDataService extends BaseDataService implements IEmployeeProjectMappingDataService{

	@Override
	public List<EmployeeProjectMapping> getEmployeeProjectMappingByProject(Long id)
			throws Exception {
		return getDataRetriever().retrieveByCriteria(new EmployeeProjectMapping(),"project.id", id.toString(), "long");
	}

	@Override
	public void saveEmployeeProjectMapping(
			EmployeeProjectMapping employeeProjectMapping) throws Exception {
		getDataModifier().updateRecord(employeeProjectMapping);
	}

	@Override
	public EmployeeProjectMapping getEmployeeProjectMapping(Long Id)
			throws Exception {
		return (EmployeeProjectMapping) getDataRetriever().retrieveByKey(new EmployeeProjectMapping(),
				Id.toString());	}

	@Override
	public void deleteEmployeeProjectMapping(
			Long Id) throws Exception {
		getDataModifier().deleteByKey(new EmployeeProjectMapping(), "id", Id.toString(), "long");
		
	}

	@Override
	public void updateEmployeeProjectMapping(
			EmployeeProjectMapping employeeProjectMapping) throws Exception {
		getDataModifier().updateRecord(employeeProjectMapping);
		
	}
	
	public List<EmployeeProjectMapping> getEmployeeProjectList(List<FilterConditions> criteriaList) throws Exception {
		return getDataRetriever().retrieveByCriteria(criteriaList);
	}

}
