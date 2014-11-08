package com.multivision.ehrms.service.data;

import java.util.List;






import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;



import com.multivision.ehrms.business.Task;
import com.multivision.ehrms.service.data.interfaces.ITaskDataService;


@Component("taskDS")
public class TaskDataService extends BaseDataService implements ITaskDataService {
	private Logger logger = Logger.getRootLogger();
	
	public List<Task> getTasks() throws Exception {
		logger.info("DataService Getting Tasks");
		return getDataRetriever().retrieveAllRecords(new Task());
	}

	
	public void saveTask(Task task) throws Exception {
		getDataModifier().updateRecord(task);
	}

	
	public Task getTask(Long Id) throws Exception {
		return (Task) getDataRetriever().retrieveByKey(new Task(),
				Id.toString());
	}

}
