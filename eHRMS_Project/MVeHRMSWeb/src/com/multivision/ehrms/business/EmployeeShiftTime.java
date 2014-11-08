package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Update: Added JPA(JSR 317) support for Hibernate to get rid of HBM files.
 * @version 2.0
 * @author Zubair Shaikh
 */

@Entity
@Table(name="Employee_Shift_Time_Update")
public class EmployeeShiftTime implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="emp_id", referencedColumnName="id")
	private Employee employee = new Employee();
	@ManyToOne
	@JoinColumn(name="project_id", referencedColumnName="id")
	private Project project = new Project();
	@Column(name="date$")
	private String date;
	private String hours;
	@Column(name="job_done")
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
