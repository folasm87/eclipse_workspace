package com.multivision.ehrms.service.business;

import org.springframework.stereotype.Component;

import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.service.business.interfaces.IUserBusinessService;
import com.multivision.ehrms.service.data.DataServiceFactory;
import com.multivision.ehrms.service.data.interfaces.IUserDataService;

/**
 * Update: Added JSR 330 support for Spring to get rid of bean definitions in application context.
 * @version 2.0
 * @author Ankit Garg 
 */

@Component("userBS")
public class UserBusinessService implements IUserBusinessService {

	public SuperUser getUserByKey(SuperUser superUser, String username)
			throws Exception {
		SuperUser newUser = null;
		if (username != null && username.trim().length() > 0) {
			DataServiceFactory dsFactory = DataServiceFactory.getInstance();
			IUserDataService userDataService = (IUserDataService) dsFactory
					.getFactory().getBean("userDS");
			newUser = userDataService.getUserByKey(superUser, username);
		}
		return newUser;
	}

	public void saveUser(SuperUser superUser) throws Exception {
		DataServiceFactory dsFactory = DataServiceFactory.getInstance();
		IUserDataService userDataService = (IUserDataService) dsFactory
				.getFactory().getBean("userDS");
		userDataService.saveUser(superUser);

	}

}
