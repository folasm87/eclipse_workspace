package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.service.business.interfaces.IRequirementBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IRequirementDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("requirementBS")
public class RequirementBusinessService implements IRequirementBusinessService {

	public List<Requirement> getRequirement() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IRequirementDataService requirementDataService = (IRequirementDataService) dsFactory
				.getFactory().getBean("requirementDS");
		return requirementDataService.getRequirement();
	}

	public void saveRequirement(Requirement requirement) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IRequirementDataService reDataService = (IRequirementDataService) dsFactory
				.getFactory().getBean("requirementDS");
		reDataService.saveRequirement(requirement);
	}

	public Requirement getRequirement(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IRequirementDataService reDataService = (IRequirementDataService) dsFactory
				.getFactory().getBean("requirementDS");
		return reDataService.getRequirement(Id);
	}

	public List<Requirement> JobSearch(String position,String location,String skill,String employer) throws Exception {

		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IRequirementDataService reDataService = (IRequirementDataService) dsFactory
				.getFactory().getBean("requirementDS");
		return reDataService.JobSearch(position, location, skill, employer);
	}
	
	public List<Requirement> getActiveRequirement() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IRequirementDataService reDataService = (IRequirementDataService) dsFactory
				.getFactory().getBean("requirementDS");
		return reDataService.getActiveRequirement();
	}

}
