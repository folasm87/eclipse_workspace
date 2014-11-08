package com.multivision.ehrms.service.business.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Task;

public interface ITaskBusinessService {
	
	public List<Task> getTasks() throws Exception;

	public void saveTask(Task task) throws Exception;

	public Task getTask(Long Id) throws Exception;


}