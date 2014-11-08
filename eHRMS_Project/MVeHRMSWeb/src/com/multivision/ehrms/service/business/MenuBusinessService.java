package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.ParentMenuManagement;
import com.multivision.ehrms.business.RoleMenuAccess;
import com.multivision.ehrms.business.SubMenuManagement;
import com.multivision.ehrms.service.business.interfaces.IMenuBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IMenuDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("menuBS")
public class MenuBusinessService implements IMenuBusinessService {

	public List<ParentMenuManagement> getParentMenuDetails() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IMenuDataService employeeDataService = (IMenuDataService) dsFactory
				.getFactory().getBean("menuDS");
		return employeeDataService.getParentMenuDetails();
	}

	public List<SubMenuManagement> getSubMenuDetails() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IMenuDataService employeeDataService = (IMenuDataService) dsFactory
				.getFactory().getBean("menuDS");
		return employeeDataService.getSubMenuDetails();
	}

	public void saveRequirement(RoleMenuAccess roleMenuAccess) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IMenuDataService employeeDataService = (IMenuDataService) dsFactory
				.getFactory().getBean("menuDS");
		employeeDataService.saveRequirement(roleMenuAccess);

	}

	public void deleteMenu(RoleMenuAccess roleMenuAccess, String keyName,
			String keyValue, String dataType) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IMenuDataService employeeDataService = (IMenuDataService) dsFactory
				.getFactory().getBean("menuDS");
		employeeDataService.deleteMenu(roleMenuAccess, keyName, keyValue,
				dataType);
	}

	public List<RoleMenuAccess> getRoleMenu(List<FilterConditions> criteriaList)
			throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IMenuDataService employeeDataService = (IMenuDataService) dsFactory
				.getFactory().getBean("menuDS");
		return employeeDataService.getRoleMenu(criteriaList);

	}

}
