package com.multivision.ehrms.action.form;

import org.apache.struts.validator.ValidatorForm;

public class RequirementForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String requirementId;
	private String clientName;
	private String clientDescription;
	private String url;
	private String positionName;
	private String noOfVancancy;
	private String endDate;
	private String positionStatus;
	private String minimumQualification;
	private String optionalRequirement;
	private String comments;
	private String status;
	private String location;
	private String skillset;
	private String type;
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getNoOfVancancy() {
		return noOfVancancy;
	}

	public void setNoOfVancancy(String noOfVancancy) {
		this.noOfVancancy = noOfVancancy;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPositionStatus() {
		return positionStatus;
	}

	public void setPositionStatus(String positionStatus) {
		this.positionStatus = positionStatus;
	}

	public String getMinimumQualification() {
		return minimumQualification;
	}

	public void setMinimumQualification(String minimumQualification) {
		this.minimumQualification = minimumQualification;
	}

	public String getOptionalRequirement() {
		return optionalRequirement;
	}

	public void setOptionalRequirement(String optionalRequirement) {
		this.optionalRequirement = optionalRequirement;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
