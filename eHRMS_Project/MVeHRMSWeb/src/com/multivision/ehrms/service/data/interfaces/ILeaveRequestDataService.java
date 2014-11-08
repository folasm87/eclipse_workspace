package com.multivision.ehrms.service.data.interfaces;

import java.util.List;

import com.multivision.ehrms.business.LeaveRequest;

public interface ILeaveRequestDataService {

	public List<LeaveRequest> getLeaveRequests() throws Exception;

	public List<LeaveRequest> getLeaveRequests(Long UserId) throws Exception;

	public void saveLeaveRequest(LeaveRequest leaveRequest) throws Exception;

	public LeaveRequest getLeaveRequest(Long Id) throws Exception;
}
