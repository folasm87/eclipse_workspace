package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Issue;
import com.multivision.ehrms.service.data.interfaces.IIssueDataService;

@Component("issueDS")
public class IssueDataService  extends BaseDataService implements IIssueDataService {

	
	public List<Issue> getIssues() throws Exception {
		return getDataRetriever().retrieveAllRecords(new Issue());
	}

	
	public void saveIssue(Issue issue) throws Exception {
		getDataModifier().updateRecord(issue);

	}

	
	public Issue getIssue(Long Id) throws Exception {
		return (Issue) getDataRetriever().retrieveByKey(new Issue(),
				Id.toString());
	}

}
