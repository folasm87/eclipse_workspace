package com.multivision.ehrms.action.form;

import org.apache.struts.validator.ValidatorForm;

import com.multivision.ehrms.business.Employee;
import com.multivision.ehrms.business.Project;

public class EmployeeShiftTimeForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Employee employee = new Employee();
	private Project project = new Project();
	private String date;
	private String hours;
	private String jobDone;
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getJobDone() {
		return jobDone;
	}

	public void setJobDone(String jobDone) {
		this.jobDone = jobDone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
