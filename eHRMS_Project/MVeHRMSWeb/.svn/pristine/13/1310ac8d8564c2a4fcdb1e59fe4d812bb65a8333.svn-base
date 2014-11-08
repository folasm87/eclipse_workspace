package com.multivision.ehrms.service.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.LeaveRequest;
import com.multivision.ehrms.service.business.interfaces.ILeaveRequestBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.ILeaveRequestDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("leaveRequestBS")
public class LeaveRequestBusinessService implements
		ILeaveRequestBusinessService {

	public List<LeaveRequest> getLeaveRequests(Long UserId) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ILeaveRequestDataService leaveRequestDataService = (ILeaveRequestDataService) dsFactory
				.getFactory().getBean("leaveRequestDS");
		return leaveRequestDataService.getLeaveRequests(UserId);
	}

	public List<LeaveRequest> getLeaveRequests() throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ILeaveRequestDataService leaveRequestDataService = (ILeaveRequestDataService) dsFactory
				.getFactory().getBean("leaveRequestDS");
		return leaveRequestDataService.getLeaveRequests();
	}

	public void saveLeaveRequest(LeaveRequest leaveRequest) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ILeaveRequestDataService leaveRequestDataService = (ILeaveRequestDataService) dsFactory
				.getFactory().getBean("leaveRequestDS");
		leaveRequestDataService.saveLeaveRequest(leaveRequest);
	}

	public LeaveRequest getLeaveRequest(Long Id) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		ILeaveRequestDataService leaveRequestDataService = (ILeaveRequestDataService) dsFactory
				.getFactory().getBean("leaveRequestDS");
		return leaveRequestDataService.getLeaveRequest(Id);
	}
}
