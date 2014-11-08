package com.multivision.ehrms.action.form;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.multivision.ehrms.business.Project;

public class IssueForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String issueId;
	
	private String issue;
	
	private Project project;
	
	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public void reset(ActionMapping mapping, ServletRequest request) {

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		ActionMessage message;
		if (this.issueId == null || this.issueId.trim().length() == 0) {
			message = new ActionMessage("task.id.mandatory");
			errors.add("taskId", message);
		}
		if (this.issue == null || this.issue.trim().length() == 0) {
			message = new ActionMessage("task.name.mandatory");
			errors.add("name", message);
		}

		return errors;
	}
	
}
