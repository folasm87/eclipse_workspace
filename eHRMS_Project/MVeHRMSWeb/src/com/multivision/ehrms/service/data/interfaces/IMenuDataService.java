package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.ParentMenuManagement;
import com.multivision.ehrms.business.RoleMenuAccess;
import com.multivision.ehrms.business.SubMenuManagement;

public interface IMenuDataService {
	
	
	public List<ParentMenuManagement> getParentMenuDetails() throws Exception;
	
	public List<SubMenuManagement> getSubMenuDetails() throws Exception;
	
	public void saveRequirement(RoleMenuAccess roleMenuAccess) throws Exception;
	
	public void deleteMenu(RoleMenuAccess roleMenuAccess, String keyName,
			String keyValue, String dataType) throws Exception;
	public List<RoleMenuAccess> getRoleMenu(List<FilterConditions> criteriaList) throws Exception;

	

}
