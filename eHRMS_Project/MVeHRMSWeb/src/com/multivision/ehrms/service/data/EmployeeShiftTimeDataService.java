package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.EmployeeShiftTime;
import com.multivision.ehrms.service.data.interfaces.IEmployeeShiftTimeDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeShiftDS")
public class EmployeeShiftTimeDataService extends BaseDataService implements
		IEmployeeShiftTimeDataService {

	
	/**
	 * Retrieve the active employees always
	 */
	public List<EmployeeShiftTime> getEmployeeShiftTime() throws Exception {
		return getDataRetriever().retrieveAllRecords(new EmployeeShiftTime());
	}

	/**
	 * Save the supplied employee information
	 */
	public void saveEmployeeShiftTime(EmployeeShiftTime employeeShiftTime) throws Exception {
		getDataModifier().updateRecord(employeeShiftTime);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public EmployeeShiftTime getEmployeeShiftTime(Long Id) throws Exception {
		return (EmployeeShiftTime) getDataRetriever().retrieveByKey(
				new EmployeeShiftTime(), Id.toString());
	}

	

}