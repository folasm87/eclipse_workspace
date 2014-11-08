package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.service.business.interfaces.IApplicantBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IApplicantDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("applicantBS")
public class ApplicantBusinessService implements
		IApplicantBusinessService {

	public List<Applicant> getApplicant() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IApplicantDataService requirementDataService = (IApplicantDataService) dsFactory
				.getFactory().getBean("applicantDS");
		return requirementDataService.getApplicant();
	}

	public Long saveApplicant(Applicant applicant) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IApplicantDataService reDataService = (IApplicantDataService) dsFactory
				.getFactory().getBean("applicantDS");
		return reDataService.saveApplicant(applicant);
	}

	public Applicant getApplicant(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IApplicantDataService reDataService = (IApplicantDataService) dsFactory
				.getFactory().getBean("applicantDS");
		return reDataService.getApplicant(Id);
	}
	
	public List<Applicant> CandiateSearch(String jobId,String eligibility,String skill,String experience) throws Exception{
		
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IApplicantDataService reDataService = (IApplicantDataService) dsFactory
				.getFactory().getBean("applicantDS");
		return reDataService.CandiateSearch(jobId, eligibility, skill, experience);
		
	}
	public List<Applicant> getApplicants(List<FilterConditions> criteriaList) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IApplicantDataService reDataService = (IApplicantDataService) dsFactory
				.getFactory().getBean("applicantDS");
		return reDataService.getApplicants(criteriaList);
		
	}
	
	
	
}
