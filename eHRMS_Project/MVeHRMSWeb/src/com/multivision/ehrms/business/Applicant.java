package com.multivision.ehrms.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.multivision.ehrms.util.Attachment;

/**
 * Update: Added JPA(JSR 317) support for Hibernate to get rid of HBM files.
 * @version 2.0
 * @author Zubair Shaikh
 */

@Entity
@Table(name="Applicant")
public class Applicant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String dob;
	private String qualification;
	private String experience;
	@Column(name="job_profile")
	private String jobProfile;
	@Column(name="mobile_no")
	private String mobileNo;
	private String email;
	@Column(name="skill_set")
	private String skillSet;
	private String resume;
	private String username;
	private String password;
	private String url;
	@Column(name="b_qualification")
	private String basicqualification;
	@Column(name="m_qualification")
	private String masterqualification;
	@Column(name="d_qualification")
	private String doctoratequalification;
	@Transient
	private List<Attachment> applicantList = new ArrayList<Attachment>();
	

	public List<Attachment> getApplicantList() {
		return applicantList;
	}

	public void setApplicantList(List<Attachment> applicantList) {
		this.applicantList = applicantList;
	}

	public String getBasicqualification() {
		return basicqualification;
	}

	public void setBasicqualification(String basicqualification) {
		this.basicqualification = basicqualification;
	}

	public String getMasterqualification() {
		return masterqualification;
	}

	public void setMasterqualification(String masterqualification) {
		this.masterqualification = masterqualification;
	}

	public String getDoctoratequalification() {
		return doctoratequalification;
	}

	public void setDoctoratequalification(String doctoratequalification) {
		this.doctoratequalification = doctoratequalification;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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

}
