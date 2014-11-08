package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Project;
import com.multivision.ehrms.service.business.interfaces.IProjectBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IProjectDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("projectBS")
public class ProjectBusinessService implements IProjectBusinessService {

	public List<Project> getProjects() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IProjectDataService projectDataService = (IProjectDataService) dsFactory
				.getFactory().getBean("projectDS");
		return projectDataService.getProjects();
	}

	public void saveProject(Project project) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IProjectDataService projectDataService = (IProjectDataService) dsFactory
				.getFactory().getBean("projectDS");
		projectDataService.saveProject(project);
	}

	public Project getProject(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IProjectDataService projectDataService = (IProjectDataService) dsFactory
				.getFactory().getBean("projectDS");
		return projectDataService.getProject(Id);
	}
}
