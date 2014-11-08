package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Resource;
import com.multivision.ehrms.service.business.interfaces.IResourceBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.ResourceDataService;
import com.multivision.ehrms.service.data.interfaces.IResourceDataService;

@Component("resourceBS")
public class ResourceBusinessService implements IResourceBusinessService{

	
	public List<Resource> getResources() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IResourceDataService resourceDataService = (ResourceDataService) dsFactory.getFactory().getBean("resourceDS");
		return resourceDataService.getResources();
	}

	
	public void saveResource(Resource requirement) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IResourceDataService resourceDataService = (ResourceDataService) dsFactory.getFactory().getBean("resourceDS");
		resourceDataService.saveResource(requirement);
		
	}

	
	public Resource getResource(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IResourceDataService resourceDataService = (ResourceDataService) dsFactory.getFactory().getBean("resourceDS");
		return resourceDataService.getResource(Id);
	}

}