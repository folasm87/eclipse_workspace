package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.data.interfaces.IApplicantDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("applicantDS")
public class ApplicantDataService extends BaseDataService implements
		IApplicantDataService {

	/**
	 * Retrieve the active employees always
	 */
	public List<Applicant> getApplicant() throws Exception {
		return getDataRetriever().retrieveAllRecords(new Applicant());
	}

	/**
	 * Save the supplied employee information
	 */
	public Long saveApplicant(Applicant applicant) throws Exception {
		return (Long) getDataModifier().updateRecord(applicant);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public Applicant getApplicant(Long Id) throws Exception {
		return (Applicant) getDataRetriever().retrieveByKey(new Applicant(),
				Id.toString());
	}

	public List<Applicant> CandiateSearch(String jobId, String eligibility,
			String skill, String experience) throws Exception {
		return getDataRetriever().CandiateSearch(jobId, eligibility, skill,
				experience);

	}
	
	public List<Applicant> getApplicants(List<FilterConditions> criteriaList) throws Exception {
		return getDataRetriever().retrieveByCriteria(criteriaList);
	}
	


}
