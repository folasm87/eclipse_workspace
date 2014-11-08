package com.multivision.ehrms.service.business.interfaces;

import com.multivision.ehrms.business.SuperUser;

public interface IUserBusinessService {

	public SuperUser getUserByKey(SuperUser superUser, String username) throws Exception;
	
	public void saveUser(SuperUser superUser) throws Exception;

}
