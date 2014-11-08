package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Issue;

public interface IIssueDataService {
	
	public List<Issue> getIssues() throws Exception;

	public void saveIssue(Issue issue) throws Exception;

	public Issue getIssue(Long Id) throws Exception;

}
