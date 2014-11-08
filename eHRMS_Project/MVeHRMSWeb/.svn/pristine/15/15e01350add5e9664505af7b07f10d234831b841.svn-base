package com.multivision.ehrms.service.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.LeaveRequest;
import com.multivision.ehrms.service.data.interfaces.ILeaveRequestDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("leaveRequestDS")
public class LeaveRequestDataService extends BaseDataService implements
		ILeaveRequestDataService {

	/**
	 * Retrieve the active employees always
	 */
	public List<LeaveRequest> getLeaveRequests(Long UserId) throws Exception {
		return getDataRetriever().retrieveByCriteria(new LeaveRequest(),
				"employee.id", UserId.toString(), "long");
	}

	public List<LeaveRequest> getLeaveRequests() throws Exception {
		return getDataRetriever().retrieveAllRecords(new LeaveRequest());
	}

	/**
	 * Save the supplied employee information
	 */
	public void saveLeaveRequest(LeaveRequest leaveRequest) throws Exception {
		getDataModifier().updateRecord(leaveRequest);
	}

	/**
	 * Retrieve the employee based on their employee ID.
	 */
	public LeaveRequest getLeaveRequest(Long Id) throws Exception {
		return (LeaveRequest) getDataRetriever().retrieveByKey(
				new LeaveRequest(), Id.toString());
	}
}
