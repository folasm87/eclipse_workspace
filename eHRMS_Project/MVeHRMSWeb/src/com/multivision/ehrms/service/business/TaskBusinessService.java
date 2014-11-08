package com.multivision.ehrms.service.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.Task;
import com.multivision.ehrms.service.business.interfaces.ITaskBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.ITaskDataService;

@Component("taskBS")
public class TaskBusinessService implements ITaskBusinessService {
	private Logger logger = Logger.getRootLogger();
	
	public List<Task> getTasks() throws Exception {
		
		//logger.info("");
		
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		
		ITaskDataService taskDataService = (ITaskDataService) dsFactory.getFactory().getBean("taskDS");
		
		return taskDataService.getTasks();
	}

	
	public void saveTask(Task task) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ITaskDataService taskDataService = (ITaskDataService) dsFactory.getFactory().getBean("taskDS");
		taskDataService.saveTask(task);

	}

	
	public Task getTask(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ITaskDataService taskDataService = (ITaskDataService) dsFactory.getFactory().getBean("taskDS");
		return taskDataService.getTask(Id);

	}

}