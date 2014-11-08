package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Update: Added JPA(JSR 317) support for Hibernate to get rid of HBM files.
 * @version 2.0
 * @author Zubair Shaikh
 */

@Entity
@Table(name="Requirement")
public class Requirement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="requirement_id")
	private String requirementId;
	@Column(name="client_name")
	private String clientName;
	@Column(name="client_description")
	private String clientDescription;
	private String url;
	@Column(name="position_name")
	private String positionName;
	@Column(name="no_of_vancancy")
	private String noOfVancancy;
	@Column(name="end_date")
	private String endDate;
	@Column(name="postion_status")
	private String positionStatus;
	@Column(name="minimum_qualification")
	private String minimumQualification;
	@Column(name="optional_requirement")
	private String optionalRequirement;
	private String comments;
	private String status;
	private String location;
	private String skillset;

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
