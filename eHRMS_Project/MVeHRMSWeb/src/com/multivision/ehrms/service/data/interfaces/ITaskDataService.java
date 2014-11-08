package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Task;



public interface ITaskDataService {
	
	public List<Task> getTasks() throws Exception;

	public void saveTask(Task task) throws Exception;

	public Task getTask(Long Id) throws Exception;

}