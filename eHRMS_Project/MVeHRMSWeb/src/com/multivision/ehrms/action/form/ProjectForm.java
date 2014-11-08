package com.multivision.ehrms.action.form;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.Resource;
import com.multivision.ehrms.business.Task;

public class ProjectForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	
	//Project Data
	private Long id;
	private String projectId;
	private String name;
	private String customer;
	private String technologies;
	private double cost;
	private String businessObjective;
	private String category;
	
	private String contractRefNo;
	private String estimatedHours;
	private double estimatedCost;
	private Employee projectCoordinator = new Employee();
	private Employee projectManager = new Employee();

	private String remarks;
	private String action;
	private String startDate;
	private String endDate;
	
	//Task Data
	
	
/*	private Set<Task> tasks;
	private Set<Resource> resources;
	*/
	
	
	//Resource Data

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getContractRefNo() {
		return contractRefNo;
	}

	public void setContractRefNo(String contractRefNo) {
		this.contractRefNo = contractRefNo;
	}

	public String getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Employee getProjectCoordinator() {
		return projectCoordinator;
	}

	public void setProjectCoordinator(Employee projectCoordinator) {
		this.projectCoordinator = projectCoordinator;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(Employee projectManager) {
		this.projectManager = projectManager;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBusinessObjective() {
		return businessObjective;
	}

	public void setBusinessObjective(String businessObjective) {
		this.businessObjective = businessObjective;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

/*	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}*/

	public void reset(ActionMapping mapping, ServletRequest request) {

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		ActionMessage message;
		if (this.projectId == null || this.projectId.trim().length() == 0) {
			message = new ActionMessage("project.id.mandatory");
			errors.add("projectId", message);
		}
		if (this.name == null || this.name.trim().length() == 0) {
			message = new ActionMessage("project.name.mandatory");
			errors.add("name", message);
		}
		return errors;
	}
}
