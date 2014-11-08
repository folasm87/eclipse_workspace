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
@Table(name="Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="emp_id")
	private String empId;
	private String name;
	private String address;
	private String dob;
	private String mobile;
	private String workphone;
	@Column(name="personal_email_id")
	private String personalEmailId;
	@Column(name="work_email_id")
	private String workEmailId;
	@Column(name="immigiration_status")
	private String immigirationStatus;
	@Column(name="stdate")
	private String joinDate;
	@Column(name="job_title")
	private String jobTitle;
	private String benefits;
	private String compensation;
	@Column(name="client_info")
	private String clientInfo;
	@Column(name="employee_type")
	private char empType;
	@Column(name="vendor_name")
	private String vendorName;
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id")
	private SystemRole role = new SystemRole();
	@Column(name="is_resigned")
	private char isResigned;
	@Column(name="resign_date")
	private String resignDate;
	@Column(name="resign_reason")
	private String resignReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	public String getWorkEmailId() {
		return workEmailId;
	}

	public void setWorkEmailId(String workEmailId) {
		this.workEmailId = workEmailId;
	}

	public String getImmigirationStatus() {
		return immigirationStatus;
	}

	public void setImmigirationStatus(String immigirationStatus) {
		this.immigirationStatus = immigirationStatus;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

	public char getEmpType() {
		return empType;
	}

	public void setEmpType(char empType) {
		this.empType = empType;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public SystemRole getRole() {
		return role;
	}

	public void setRole(SystemRole role) {
		this.role = role;
	}

	public char getIsResigned() {
		return isResigned;
	}

	public void setIsResigned(char isResigned) {
		this.isResigned = isResigned;
	}

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public String getResignReason() {
		return resignReason;
	}

	public void setResignReason(String resignReason) {
		this.resignReason = resignReason;
	}

}
