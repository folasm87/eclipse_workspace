package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;

public interface IApplicantBusinessService {

	public List<Applicant> getApplicant() throws Exception;

	public Long saveApplicant(Applicant applicant) throws Exception;

	public Applicant getApplicant(Long Id) throws Exception;
	
	public List<Applicant> CandiateSearch(String jobId,String eligibility,String skill,String experience) throws Exception;
	
	public List<Applicant> getApplicants(List<FilterConditions> criteriaList) throws Exception;
}
