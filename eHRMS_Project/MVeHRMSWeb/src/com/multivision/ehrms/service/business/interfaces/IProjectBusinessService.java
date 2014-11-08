package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Project;

public interface IProjectBusinessService {

	public List<Project> getProjects() throws Exception;

	public void saveProject(Project project) throws Exception;

	public Project getProject(Long Id) throws Exception;
}
