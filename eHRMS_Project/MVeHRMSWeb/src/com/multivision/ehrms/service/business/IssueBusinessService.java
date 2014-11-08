package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Issue;
import com.multivision.ehrms.service.business.interfaces.IIssueBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IIssueDataService;
import com.multivision.ehrms.service.data.interfaces.ITaskDataService;

@Component("issueBS")
public class IssueBusinessService implements IIssueBusinessService {

	
	public List<Issue> getIssues() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IIssueDataService issueDataService = (IIssueDataService) dsFactory.getFactory().getBean("issueDS");
		
		return issueDataService.getIssues();
	}

	
	public void saveIssue(Issue issue) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IIssueDataService issueDataService = (IIssueDataService) dsFactory.getFactory().getBean("issueDS");
		
		issueDataService.saveIssue(issue);

	}

	
	public Issue getIssue(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		IIssueDataService issueDataService = (IIssueDataService) dsFactory.getFactory().getBean("issueDS");
		
		return issueDataService.getIssue(Id);
	}

}