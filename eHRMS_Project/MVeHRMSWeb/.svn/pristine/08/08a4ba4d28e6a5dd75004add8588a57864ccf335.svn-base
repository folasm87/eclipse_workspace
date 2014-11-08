package com.multivision.ehrms.action;

import java.io.File;
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

import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.util.Attachment;
import com.multivision.ehrms.util.CommonUtil;

public class DownloadResumeAction extends BaseDispatchAction {

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
			}
		}
		return forward;
	}

	@SuppressWarnings({ "unchecked" })
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing employee information");
		ActionForward forward = null;
		String value = request.getParameter("path");
		String profileValue = null;
		List<Attachment> attachment = new ArrayList<Attachment>();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("attached") != null) {
			attachment = (List<Attachment>) session.getAttribute("attached");
		} else {
			attachment = getLocations(value);
		}
		Iterator<Attachment> it = attachment.iterator();
		while (it.hasNext()) {
			Attachment att = it.next();
			if (value.equals(att.getAttachmentpath())) {
				profileValue = att.getAttachmentpath();
			}
		}
		String pathvalue = File.separator + "usr" + File.separator + "share"
				+ File.separator + "eHRMS" + File.separator + "upload"
				+ File.separator + "resume";

		profileValue = pathvalue + File.separatorChar + profileValue;
		CommonUtil commonUtil = new CommonUtil();
		commonUtil.fileDownload(request, response, profileValue, value);
		forward = mapping.findForward("list");
		return forward;
	}

	private List<Attachment> getLocations(String path) {
		List<Attachment> attachment = new ArrayList<Attachment>();
		StringTokenizer stringTokenizer = new StringTokenizer(path, ",");
		while (stringTokenizer.hasMoreTokens()) {
			Attachment att = new Attachment();
			att.setAttachmentpath(stringTokenizer.nextToken());
			attachment.add(att);
		}
		return attachment;
	}

}