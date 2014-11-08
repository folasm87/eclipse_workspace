package com.multivision.ehrms.action.form;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.multivision.ehrms.business.SystemRole;

public class EmployeeForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String empId;
	private String name;
	private String address;
	private String dob;
	private String mobile;
	private String workphone;
	private String personalEmailId;
	private String workEmailId;
	private String immigirationStatus;
	private String joinDate;
	private String jobTitle;
	private String benefits;
	private String compensation;
	private String clientInfo;
	private char empType;
	private String vendorName;
	private SystemRole role = new SystemRole();
	private char isResigned;
	private String resignDate;
	private String resignReason;
	private String action;

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void reset(ActionMapping mapping, ServletRequest request) {

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		ActionMessage message;
		if (this.empId == null || this.empId.trim().length() == 0) {
			message = new ActionMessage("employee.id.mandatory");
			errors.add("empid", message);
		}
		if (this.name == null || this.name.trim().length() == 0) {
			message = new ActionMessage("employee.name.mandatory");
			errors.add("name", message);
		}
		if (this.dob == null || this.dob.trim().length() == 0) {
			message = new ActionMessage("employee.dob.mandatory");
			errors.add("dob", message);
		}
		if (this.joinDate == null || this.joinDate.trim().length() == 0) {
			message = new ActionMessage("employee.joindate.mandatory");
			errors.add("joinDate", message);
		}
		return errors;
	}
}
