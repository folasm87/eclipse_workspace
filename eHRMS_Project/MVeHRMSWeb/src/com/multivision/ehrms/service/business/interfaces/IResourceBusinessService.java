package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Resource;

public interface IResourceBusinessService {
	
	public List<Resource> getResources() throws Exception;

	public void saveResource(Resource requirement) throws Exception;

	public Resource getResource(Long Id) throws Exception;

}
