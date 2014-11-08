package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.ParentMenuManagement;
import com.multivision.ehrms.business.RoleMenuAccess;
import com.multivision.ehrms.business.SubMenuManagement;
import com.multivision.ehrms.service.data.interfaces.IMenuDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("menuDS")
public class MenuDataService extends BaseDataService implements
		IMenuDataService {

	/**
	 * Retrieve the active Module always
	 */
	public List<ParentMenuManagement> getParentMenuDetails() throws Exception {
		return getDataRetriever()
				.retrieveAllRecords(new ParentMenuManagement());
	}

	public List<SubMenuManagement> getSubMenuDetails() throws Exception {
		return getDataRetriever().retrieveAllRecords(new SubMenuManagement());
	}

	public void saveRequirement(RoleMenuAccess roleMenuAccess) throws Exception {
		getDataModifier().updateRecord(roleMenuAccess);

	}

	public void deleteMenu(RoleMenuAccess roleMenuAccess, String keyName,
			String keyValue, String dataType) throws Exception {
		getDataModifier().deleteByMenu(roleMenuAccess, keyName, keyValue, dataType);

	}
	
	public List<RoleMenuAccess> getRoleMenu(List<FilterConditions> criteriaList) throws Exception {
		return getDataRetriever().retrieveByCriteria(criteriaList);
	}

}
