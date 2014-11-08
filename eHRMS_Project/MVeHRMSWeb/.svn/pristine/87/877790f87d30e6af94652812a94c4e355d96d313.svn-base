package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.SystemRole;
import com.multivision.ehrms.service.data.interfaces.ISystemRoleDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("systemRoleDS")
public class SystemRoleDataService extends BaseDataService implements
		ISystemRoleDataService {

	public List<SystemRole> getSystemRoles() throws Exception {
		return getDataRetriever().retrieveAllRecords(new SystemRole());
	}
}
