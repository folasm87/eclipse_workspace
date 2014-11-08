package com.multivision.ehrms.service.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.service.data.interfaces.IRequirementDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("requirementDS")
public class RequirementDataService extends BaseDataService implements
		IRequirementDataService {

	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Retrieve the active employees always
	 */
	public List<Requirement> getRequirement() throws Exception {
		return getDataRetriever().retrieveAllRecords(new Requirement());
	}

	/**
	 * Save the supplied employee information
	 */
	public void saveRequirement(Requirement requirement) throws Exception {
		getDataModifier().updateRecord(requirement);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public Requirement getRequirement(Long Id) throws Exception {
		return (Requirement) getDataRetriever().retrieveByKey(
				new Requirement(), Id.toString());
	}

	public List<Requirement> JobSearch(String position,String location,String skill,String employer) throws Exception {
		return getDataRetriever().JobSearch(position,location,skill,employer);
	}
	
	public List<Requirement> getActiveRequirement() throws Exception {
		return getDataRetriever().retrieveByCriteria(new Requirement(),
				"status", "Active", "String");
	}

}