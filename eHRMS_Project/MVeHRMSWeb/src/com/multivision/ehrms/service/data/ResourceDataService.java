package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Resource;
import com.multivision.ehrms.service.data.interfaces.IResourceDataService;

@Component("resourceDS")
public class ResourceDataService extends BaseDataService implements IResourceDataService {

	
	public List<Resource> getResources() throws Exception {
		return getDataRetriever().retrieveAllRecords(new Resource());
	}

	
	public void saveResource(Resource resource) throws Exception {
		getDataModifier().updateRecord(resource);
	}

	
	public Resource getResource(Long Id) throws Exception {
		return (Resource) getDataRetriever().retrieveByKey(new Resource(),
				Id.toString());
	}

}