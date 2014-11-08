package com.multivision.ehrms.service.data;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.service.data.interfaces.IUserDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("userDS")
public class UserDataService extends BaseDataService implements
		IUserDataService {

	public SuperUser getUserByKey(SuperUser superUser, String username) throws Exception {
		SuperUser newUser = (SuperUser) getDataRetriever().retrieveByKey(superUser, username);
		return newUser;
	}
	
	public void saveUser(SuperUser superUser) throws Exception{
		getDataModifier().updateRecord(superUser);
		
	}
}
