package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.Entity;
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
@Table(name="Super_Users")
public class SuperUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id")
	private SystemRole systemRole = new SystemRole();
	@ManyToOne
	@JoinColumn(name="applicant_id", referencedColumnName="id")
	private Applicant applicant = new Applicant();
	@ManyToOne
	@JoinColumn(name="emp_id", referencedColumnName="id")
	private Employee employee = new Employee();

	public SystemRole getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
