package com.multivision.ehrms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;



import com.multivision.ehrms.action.form.ResourceForm;
import com.multivision.ehrms.business.Resource;
import com.multivision.ehrms.business.Project;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.service.business.BusinessServiceFactory;
import com.multivision.ehrms.service.business.interfaces.IResourceBusinessService;
import com.multivision.ehrms.service.business.interfaces.IProjectBusinessService;

public class ResourceAction extends BaseDispatchAction {
	
	private Logger logger = Logger.getRootLogger();
	BusinessServiceFactory bsFactory;

	public BusinessServiceFactory getBsFactory() {
		return bsFactory;
	}

	public void setBsFactory(BusinessServiceFactory bsFactory) {
		this.bsFactory = bsFactory;
	}

	@Override
	protected ActionForward perform(ActionMapping mapping, ActionForm form,
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
			} else if (parameter.equalsIgnoreCase("view")) {
				forward = view(mapping, form, request, response);
			}
		}
		return forward;
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Listing resource information");
		ActionForward forward = null;
		List<Resource> resources = getResources();
		request.setAttribute("RESOURCES", resources);
		forward = mapping.findForward("list");
		return forward;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying add screen to add resource details");
		ActionForward forward = null;
		ResourceForm resourceForm = (ResourceForm) form;
		resourceForm.setAction("add");
		clearFormValues(resourceForm);
		request.getSession(false).setAttribute("PROJECTS", fetchProjects());
		forward = mapping.findForward("add");
		return forward;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying edit screen to edit resource details");
		ActionForward forward = null;
		ResourceForm resourceForm = (ResourceForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Resource resource = fetchResource(Id);
		request.getSession(false).setAttribute("PROJECTS", fetchProjects());
		resourceForm.setAction("edit");
		setFormValues(resourceForm, resource);
		forward = mapping.findForward("edit");
		return forward;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Displaying view screen to display resource details");
		ActionForward forward = null;
		ResourceForm resourceForm = (ResourceForm) form;
		Long Id = null;
		if (request.getParameter("id") != null
				&& request.getParameter("id").length() > 0) {
			Id = Long.valueOf(request.getParameter("id"));
		}
		Resource resource = fetchResource(Id);
		setFormValues(resourceForm, resource);
		forward = mapping.findForward("view");
		return forward;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Trying to save the resource details");
		ActionForward forward = null;
		ActionMessages messages = new ActionMessages();
		forward = mapping.findForward("save");
		ResourceForm resourceForm = (ResourceForm) form;
		try {
			saveValues(resourceForm);
			messages.add("project_add_status", new ActionMessage(
					"project.data.added.success"));
			saveMessages(request, messages);
			resourceForm.setAction("save");
			logger.info("Saved the employee details");
		} catch (DataSourceConnectivityFailedException dscfException) {
			logger.debug(dscfException);
			messages.add("project_add_status", new ActionMessage(
					"global.db.connectivity.failure"));
			saveMessages(request, messages);
		} catch (DuplicateRecordException drException) {
			logger.debug(drException);
			messages.add("project_add_status", new ActionMessage(
					"project.data.added.duplicate.failed"));
			saveMessages(request, messages);
		} catch (Exception exception) {
			logger.debug(exception);
			messages.add("project_add_status",
					new ActionMessage("project.data.added.general.failure",
							exception.getMessage()));
			saveMessages(request, messages);
		}
		return forward;
	}

	private List<Resource> getResources() throws Exception {
		List<Resource> resources = new ArrayList<Resource>();
		IResourceBusinessService projectService = (IResourceBusinessService) getBsFactory()
				.getFactory().getBean("resourceBS");
		resources = projectService.getResources();
		return resources;
	}

	private void clearFormValues(ResourceForm ResourceForm) {
		ResourceForm.setName("");
		ResourceForm.setCost(0.0);
		ResourceForm.setResourceId(null);
		ResourceForm.setProject(new Project());
	}

	private void setFormValues(ResourceForm resourceForm, Resource resource) {
		resourceForm.setId(resource.getId());
		resourceForm.setResourceId(resource.getResourceId());
		resourceForm.setName(resource.getName());
		resourceForm.setCost(resource.getCost());
		resourceForm.setProject(resource.getProject());
		resourceForm.getProject().setId(
				resource.getProject().getId());
		resourceForm.getProject().setName(
				resource.getProject().getName());
	}

	private void saveValues(ResourceForm resourceForm) throws Exception {
		Resource resource = saveFormValues(resourceForm);
		logger.info("1a");
		IResourceBusinessService resourceService = (IResourceBusinessService) getBsFactory()
				.getFactory().getBean("resourceBS");
		logger.info("1b");
		resourceService.saveResource(resource);
	}

	private Resource saveFormValues(ResourceForm resourceForm) throws Exception {
		logger.info("1c");
		Resource resource = new Resource();
		logger.info("1d");
		if (!resourceForm.getAction().equalsIgnoreCase("add")) {
			resource.setId(resourceForm.getId());
		}
		logger.info("1d");
		resource.setResourceId(resourceForm.getResourceId());
		logger.info("1e");
		resource.setName(resourceForm.getName());
		logger.info("1f");
		resource.setCost(resourceForm.getCost());
		logger.info("1g");
		resource.setProject(resourceForm.getProject());
		logger.info("1h");
		resource.getProject().setId(
				resourceForm.getProject().getId());
		logger.info("1i");
		resource.getProject().setName(
				resourceForm.getProject().getName());
		logger.info("1j");
		return resource;
	}

	private List<Project> fetchProjects() throws Exception {
		List<Project> projects = new ArrayList<Project>();
		IProjectBusinessService projectService = (IProjectBusinessService) getBsFactory()
				.getFactory().getBean("projectBS");
		projects = projectService.getProjects();
		return projects;
	}

	private Resource fetchResource(Long Id) throws Exception {
		Resource resource = null;
		IResourceBusinessService resourceService = (IResourceBusinessService) getBsFactory()
				.getFactory().getBean("resourceBS");
		resource = resourceService.getResource(Id);
		return resource;
	}

}
