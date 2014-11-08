package com.multivision.ehrms.action.form;



import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.Project;

public class TaskForm extends ValidatorForm{

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String taskId;
	
	private String name;
	
	private String estimatedHours;
	
	private Project project;
	
	private Employee taskHandler;
	
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

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Employee getTaskHandler() {
		return taskHandler;
	}

	public void setTaskHandler(Employee taskHandler) {
		this.taskHandler = taskHandler;
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
		if (this.taskId == null || this.taskId.trim().length() == 0) {
			message = new ActionMessage("task.id.mandatory");
			errors.add("taskId", message);
		}
		if (this.name == null || this.name.trim().length() == 0) {
			message = new ActionMessage("task.name.mandatory");
			errors.add("name", message);
		}

		return errors;
	}
	
	
	
}
