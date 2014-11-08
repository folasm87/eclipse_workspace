package com.multivision.ehrms.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.multivision.ehrms.action.form.ApplicantForm;
import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IApplicantBusinessService;
import com.multivision.ehrms.service.business.interfaces.IUserBusinessService;
import com.multivision.ehrms.util.Attachment;
import com.multivision.ehrms.util.CommonUtil;

public class ApplicantAction extends BaseDispatchAction {

	private Logger logger = Logger.getRootLogger();
	BusinessServiceFactory bsFactory;

	public BusinessServiceFactory getBsFactory() {
		return bsFactory;
	}

	public void setBsFactory(BusinessServiceFactory bsFactory) {
		this.bsFactory = bsFactory;
	}

	@Override
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		if (request.getParameter("method") != null) {
			String parameter = request.getParameter("method");
			if (parameter.equalsIgnoreCase("list")) {
				forward = list(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("add")) {
				forward = add(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("save")) {
				forward = save(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("edit")) {
				forward = edit(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing applicant information");
		ActionForward forward = null;
		ApplicantForm applicantForm = (ApplicantForm) form;
		clearFormValues(applicantForm);
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add Applicant details");
		ActionForward forward = null;
		ApplicantForm applicantForm = (ApplicantForm) form;
		clearFormValues(applicantForm);
		accessMenu(request, applicantForm);
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit Applicant details");
		ActionForward forward = null;
		ApplicantForm applicantForm = (ApplicantForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Applicant applicant = fetchApplicant(Id);
		setFormValues(applicantForm, applicant);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the applicant details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		ApplicantForm applicantForm = (ApplicantForm) form;
		accessMenu(request, applicantForm);
		try {
			saveValues(applicantForm, request);
			applicantForm.setOperation('S');
			messages.add("applicant_add_status", new ActionMessage(
					"applicant.data.added.success"));
			saveMessages(request, messages);
			logger.info("Saved the applicant details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("applicant_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("applicant_add_status", new ActionMessage(
					"applicant.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("applicant_add_status",
					new ActionMessage("applicant.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private void clearFormValues(ApplicantForm applicantForm) {
		applicantForm.setName("");
		applicantForm.setDob("");
		applicantForm.setQualification("");
		applicantForm.setExperience("");
		applicantForm.setJobProfile("");
		applicantForm.setMobileNo("");
		applicantForm.setEmail("");
		applicantForm.setSkillSet("");
		applicantForm.setOperation('A');
		applicantForm.setResume("");
		applicantForm.setUsername("");
		applicantForm.setPassword("");
		applicantForm.setBasicqualification("");
		applicantForm.setMasterqualification("");
		applicantForm.setDoctoratequalification("");
	}

	private void setFormValues(ApplicantForm applicantForm, Applicant applicant) {
		applicantForm.setId(applicant.getId());
		applicantForm.setName(applicant.getName());
		applicantForm.setDob(applicant.getDob());
		applicantForm.setQualification(applicant.getQualification());
		applicantForm.setExperience(applicant.getExperience());
		applicantForm.setJobProfile(applicant.getJobProfile());
		applicantForm.setMobileNo(applicant.getMobileNo());
		applicantForm.setEmail(applicant.getEmail());
		applicantForm.setSkillSet(applicant.getSkillSet());
		applicantForm.setResume(applicant.getResume());
		applicantForm.setUsername(applicant.getUsername());
		applicantForm.setPassword(applicant.getPassword());
		applicantForm.setBasicqualification(applicant.getBasicqualification());
		applicantForm
				.setMasterqualification(applicant.getMasterqualification());
		applicantForm.setDoctoratequalification(applicant
				.getDoctoratequalification());

	}

	private void saveValues(ApplicantForm applicantForm,
			HttpServletRequest request) throws Exception {
		FormFile formfile = null;
		HttpSession session = request.getSession(false);
		List<FormFile> formfilelt = new ArrayList<FormFile>();
		formfilelt.add(formfile);
		Applicant applicant = new Applicant();
		List<String> filePath = getStoredLocation(request, applicantForm,
				applicant);
		String paths = getAllPaths(filePath);
		List<Attachment> attList = getLocations(paths);
		applicant = saveFormValues(applicantForm);
		applicant.setUrl(paths);
		IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
				.getFactory().getBean("applicantBS");
		IUserBusinessService userService = (IUserBusinessService) getBsFactory()
				.getFactory().getBean("userBS");
		Long applicantId = lService.saveApplicant(applicant);
		SuperUser superUser = new SuperUser();
		superUser.setUsername(applicantForm.getUsername());
		superUser.setPassword(applicantForm.getPassword());
		Long id = (long) 8;
		superUser.getApplicant().setId(applicantId);
		superUser.setEmployee(null);
		superUser.getSystemRole().setId(id);
		superUser.setEmployee(null);
		userService.saveUser(superUser);
		session.setAttribute("attached", attList);
	}

	private Applicant saveFormValues(ApplicantForm lForm) throws Exception {
		Applicant applicant = new Applicant();
		applicant.setId(lForm.getId());
		applicant.setName(lForm.getName());
		applicant.setDob(lForm.getDob());
		applicant.setQualification(lForm.getQualification());
		applicant.setExperience(lForm.getExperience());
		applicant.setJobProfile(lForm.getJobProfile());
		applicant.setMobileNo(lForm.getMobileNo());
		applicant.setEmail(lForm.getEmail());
		applicant.setSkillSet(lForm.getSkillSet());
		applicant.setResume(lForm.getResume());
		applicant.setUsername(lForm.getUsername());
		applicant.setPassword(lForm.getPassword());
		applicant.setBasicqualification(lForm.getBasicqualification());
		applicant.setMasterqualification(lForm.getMasterqualification());
		applicant.setDoctoratequalification(lForm.getDoctoratequalification());

		return applicant;
	}

	private Applicant fetchApplicant(Long Id) throws Exception {
		Applicant applicant = null;
		IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
				.getFactory().getBean("applicantBS");
		applicant = lService.getApplicant(Id);
		return applicant;
	}

	private List<String> getStoredLocation(HttpServletRequest request,
			ApplicantForm applicantForm, Applicant applicant)
			throws FileNotFoundException, IOException, Exception {
		List<String> courseFileList = new ArrayList<String>();
		List<FormFile> formFiles = applicantForm.getUploads();
		int i;
		FormFile courseFile = null;
		for (i = 0; formFiles != null && i < formFiles.size(); i++) {
			if (formFiles.get(i) != null) {
				courseFile = formFiles.get(i);
				courseFileList.add(storeFile(request, applicantForm,
						courseFile, applicant));

			}
		}
		return courseFileList;
	}

	private String storeFile(HttpServletRequest request,
			ApplicantForm applicantForm, FormFile formFile, Applicant applicant)
			throws FileNotFoundException, IOException, Exception {
		CommonUtil util = new CommonUtil();
		String path = File.separator + "resume" + File.separator;
		String fileName = formFile.getFileName();
		if (fileName != null && !fileName.equals("")) {
			util.dataUpload(request, path, fileName, formFile);
		}
		return fileName;
	}

	public String getAllPaths(List<String> paths) {
		Iterator<String> it = paths.iterator();
		String allpaths = "";
		while (it.hasNext()) {
			if (allpaths.equals("")) {
				allpaths = it.next();
			} else {
				allpaths = allpaths + "," + it.next();
			}
		}
		return allpaths;
	}

	private List<Attachment> getLocations(String paths) {
		List<Attachment> attachment = new ArrayList<Attachment>();
		StringTokenizer stringTokenizer = new StringTokenizer(paths, ",");
		while (stringTokenizer.hasMoreTokens()) {
			Attachment att = new Attachment();
			att.setAttachmentpath(stringTokenizer.nextToken());
			attachment.add(att);
		}
		return attachment;
	}

	private void accessMenu(HttpServletRequest request,
			ApplicantForm applicantForm) throws Exception {
		HttpSession session = request.getSession(false);
		SuperUser superUser = (SuperUser) session.getAttribute("user");
		if (superUser != null) {
			IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
					.getFactory().getBean("applicantBS");
			List<FilterConditions> criteriaList = new ArrayList<FilterConditions>();
			FilterConditions filterConditions = new FilterConditions(
					new Applicant(), "username", superUser.getUsername(),
					"String");
			List<Applicant> appList = new ArrayList<Applicant>();
			criteriaList.add(filterConditions);
			appList = lService.getApplicants(criteriaList);
			if (appList.size() > 0) {
				Applicant applicant = appList.get(0);
				List<Attachment> attList = getLocations(applicant.getUrl());
				setFormValues(applicantForm, applicant);
				session.setAttribute("attached", attList);
			}
			request.setAttribute("appList", appList);

		}
	}

}
