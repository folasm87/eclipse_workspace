package com.multivision.ehrms.action.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class ApplicantForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String dob;
	private String qualification;
	private String experience;
	private String jobProfile;
	private String mobileNo;
	private String email;
	private String skillSet;
	private String resume;
	private String username;
	private String password;
	private FormFile theFile;
	private char operation = 'A';
	private String basicqualification;
	private String masterqualification;
	private String doctoratequalification;

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

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	/** The form files. */
	private List<FormFile> formFiles = new ArrayList<FormFile>();

	public FormFile getTheFile() {
		return theFile;
	}

	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}

	public List<FormFile> getFormFiles() {
		return formFiles;
	}

	public void setFormFiles(List<FormFile> formFiles) {
		this.formFiles = formFiles;
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

	public List<FormFile> getUploads() {
		return this.formFiles;
	}

	public void setUploads(int iIndex, FormFile formFile) {
		if (!formFile.getFileName().equals("")) {
			if (this.formFiles.size() <= iIndex) {

				for (int i = this.formFiles.size(); i < iIndex; i++) {
					this.formFiles.add(null);
				}
				this.formFiles.add(formFile);
			} else {
				this.formFiles.set(iIndex, formFile);
			}
		}
	}

}
