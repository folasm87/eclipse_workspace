package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Resource;

public interface IResourceDataService {
	
	public List<Resource> getResources() throws Exception;

	public void saveResource(Resource requirement) throws Exception;

	public Resource getResource(Long Id) throws Exception;

}
