package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Issue;


public interface IIssueBusinessService {
	
	public List<Issue> getIssues() throws Exception;

	public void saveIssue(Issue issue) throws Exception;

	public Issue getIssue(Long Id) throws Exception;

}
