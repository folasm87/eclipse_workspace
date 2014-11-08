package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.EmployeeShiftTime;
import com.multivision.ehrms.service.business.interfaces.IEmployeeShiftTimeBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IEmployeeShiftTimeDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("employeeShiftBS")
public class EmployeeShiftTimeBusinessService implements IEmployeeShiftTimeBusinessService {

	public List<EmployeeShiftTime> getEmployeeShiftTime() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeShiftTimeDataService employeeDataService = (IEmployeeShiftTimeDataService) dsFactory
				.getFactory().getBean("employeeShiftDS");
		return employeeDataService.getEmployeeShiftTime();
	}

	public void saveEmployeeShiftTime(EmployeeShiftTime employeeShiftTime) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeShiftTimeDataService employeeDataService = (IEmployeeShiftTimeDataService) dsFactory
				.getFactory().getBean("employeeShiftDS");
		employeeDataService.saveEmployeeShiftTime(employeeShiftTime);
	}

	public EmployeeShiftTime getEmployeeShiftTime(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IEmployeeShiftTimeDataService employeeDataService = (IEmployeeShiftTimeDataService) dsFactory
				.getFactory().getBean("employeeShiftDS");
		return employeeDataService.getEmployeeShiftTime(Id);
	}
}
