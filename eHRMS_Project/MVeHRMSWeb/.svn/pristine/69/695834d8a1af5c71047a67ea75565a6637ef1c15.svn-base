package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.service.business.interfaces.ISystemRoleBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.ISystemRoleDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("systemRoleBS")
public class SystemRoleBusinessService implements ISystemRoleBusinessService {

	public List<SystemRole> getSystemRoles() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ISystemRoleDataService systemRoleDataService = (ISystemRoleDataService) dsFactory
				.getFactory().getBean("systemRoleDS");
		return systemRoleDataService.getSystemRoles();
	}
}
