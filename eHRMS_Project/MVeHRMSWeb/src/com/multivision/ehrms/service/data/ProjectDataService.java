package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Project;
import com.multivision.ehrms.service.data.interfaces.IProjectDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("projectDS")
public class ProjectDataService extends BaseDataService implements
		IProjectDataService {

	/**
	 * Retrieve the active employees always
	 */
	public List<Project> getProjects() throws Exception {
		return getDataRetriever().retrieveAllRecords(new Project());
	}

	/**
	 * Save the supplied employee information
	 */
	public void saveProject(Project project) throws Exception {
		getDataModifier().updateRecord(project);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public Project getProject(Long Id) throws Exception {
		return (Project) getDataRetriever().retrieveByKey(new Project(),
				Id.toString());
	}
}
