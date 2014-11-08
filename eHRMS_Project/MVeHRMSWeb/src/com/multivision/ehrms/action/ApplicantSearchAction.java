package com.multivision.ehrms.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.multivision.ehrms.action.form.ApplicantForm;
import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IApplicantBusinessService;
import com.multivision.ehrms.service.business.interfaces.IRequirementBusinessService;
import com.multivision.ehrms.util.Attachment;
import com.multivision.ehrms.util.CommonUtil;

public class ApplicantSearchAction extends BaseDispatchAction {

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
			if (parameter.equalsIgnoreCase("add")) {
				forward = add(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("search")) {
				forward = search(mapping, form, request, response);
			} else if (parameter.equalsIgnoreCase("report")) {
				forward = report(mapping, form, request, response);
			}
		}
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Display candidate search screen");
		ActionForward forward = null;
		List<Requirement> requirementList = getRequirement();
		request.setAttribute("requirementList", requirementList);
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying the search result for canidadate search");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		List<Applicant> appList = new ArrayList<Applicant>();
		ApplicantForm applicantForm = (ApplicantForm) form;
		IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
				.getFactory().getBean("applicantBS");
		appList = getApplicantDetails(applicantForm, lService);
		List<Requirement> requirementList = getRequirement();
		request.setAttribute("requirementList", requirementList);
		request.setAttribute("appList", appList);
		if (appList.size() == 0) {
			messages.add("applicant_search_status", new ActionMessage(
					"label.not.found"));
			saveMessages(request, messages);
		}
		forward = mapping.findForward("add");
		return forward;
	}

	private List<Applicant> getApplicantDetails(ApplicantForm applicantForm,
			IApplicantBusinessService lService) throws Exception {
		List<Applicant> appList;
		String jobId = applicantForm.getJobProfile();
		String eligibility = applicantForm.getQualification();
		String skill = applicantForm.getSkillSet();
		String experience = applicantForm.getExperience();
		appList = lService
				.CandiateSearch(jobId, eligibility, skill, experience);
		List<Applicant> applicantList =new ArrayList<Applicant>();
		for(Applicant applicant:appList){
			String path = applicant.getUrl();
			List<Attachment> attList = getLocations(path);
			applicant.setApplicantList(attList);
			applicantList.add(applicant);
		}
		return applicantList;
	}

	public ActionForward report(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying the search result for canidadate search");
		ActionForward forward = null;
		CommonUtil commonUtil = new CommonUtil();
		HttpSession session = request.getSession(false);
		ServletContext context = session.getServletContext();
		String realPath = generateExcelSheet(form, request, context);
		commonUtil.xlsDownload(request, response, realPath + File.separator
				+ "Applicant.xls", "Applicant.xls");
		forward = mapping.findForward("add");
		return forward;
	}
	
	private List<Requirement> getRequirement() throws Exception {
		List<Requirement> requirement = new ArrayList<Requirement>();
		IRequirementBusinessService lService = (IRequirementBusinessService) getBsFactory()
		.getFactory().getBean("requirementBS");
		requirement = lService.getActiveRequirement();
		return requirement;
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


	private String generateExcelSheet(ActionForm form,
			HttpServletRequest request, ServletContext context)
			throws IOException, Exception, WriteException {
		List<Applicant> appList;
		String realPath = context.getRealPath(request.getContextPath());
		realPath = realPath.substring(0, realPath.lastIndexOf("MVeHRMS") - 1);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));
		String filename = "Applicant.xls";
		WritableWorkbook workbook = Workbook.createWorkbook(new File(realPath
				+ File.separator + filename), ws);
		WritableSheet s1 = workbook.createSheet("Sheet1", 0);
		IApplicantBusinessService lService = (IApplicantBusinessService) getBsFactory()
				.getFactory().getBean("applicantBS");
		ApplicantForm applicantForm = (ApplicantForm) form;
		appList = getApplicantDetails(applicantForm, lService);
		writeImageSheet(s1, appList);
		workbook.write();
		workbook.close();
		return realPath;
	}

	private static void writeImageSheet(WritableSheet s, List<Applicant> appList)
			throws WriteException {

		WritableFont wf = new WritableFont(WritableFont.ARIAL, 8,
				WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);

		/* Creates Label and writes date to one cell of sheet */
		Label h = new Label(0, 0, "Applicant ID", cf);
		s.addCell(h);

		Label h2 = new Label(1, 0, "Applicant Name", cf);
		s.addCell(h2);

		Label h3 = new Label(2, 0, "DOB", cf);
		s.addCell(h3);

		Label h4 = new Label(3, 0, "Education", cf);
		s.addCell(h4);

		Label h5 = new Label(4, 0, "Industry", cf);
		s.addCell(h5);

		Label h6 = new Label(5, 0, "Years of experience", cf);
		s.addCell(h6);

		Label h7 = new Label(6, 0, "Skillset", cf);
		s.addCell(h7);

		Label h8 = new Label(7, 0, "Contact Number", cf);
		s.addCell(h8);

		Label h9 = new Label(8, 0, "Email ID ", cf);
		s.addCell(h9);

		for (int i = 0; i < appList.size(); i++) {
			int j = i + 1;
			Applicant applicant = appList.get(i);
			Label l = new Label(0, j, applicant.getId() + "");
			s.addCell(l);

			Label l1 = new Label(1, j, applicant.getName());
			s.addCell(l1);

			Label l2 = new Label(2, j, applicant.getDob());
			s.addCell(l2);

			Label l3 = new Label(3, j, applicant.getMasterqualification());
			s.addCell(l3);

			Label l4 = new Label(4, j, applicant.getJobProfile());
			s.addCell(l4);

			Label l5 = new Label(5, j, applicant.getExperience());
			s.addCell(l5);

			Label l6 = new Label(6, j, applicant.getSkillSet());
			s.addCell(l6);

			Label l7 = new Label(7, j, applicant.getMobileNo());
			s.addCell(l7);

			Label l8 = new Label(8, j, applicant.getEmail());
			s.addCell(l8);

		}
	}

}
