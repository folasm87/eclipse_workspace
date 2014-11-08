package com.multivision.ehrms.service.business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.multivision.ehrms.business.SuperUser;
import com.multivision.ehrms.service.business.interfaces.IUserBusinessService;

/**
 * This component will be used by the Spring security framework for
 * authentication. This component uses the UserBusinessService component for
 * authentication.
 * 
 * @author Esakki
 * 
 */

public class UserDetailsServiceImpl implements UserDetailsService {

	private static final long serialVersionUID = 1L;
	private String password;
	private String username;

	public UserDetailsServiceImpl() {

	}

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		this.username = userName;
		return makeUser(username);
	}

	@SuppressWarnings("deprecation")
	private org.springframework.security.core.userdetails.User makeUser(
			String username) {
		BusinessServiceFactory bsFactory = BusinessServiceFactory.getInstance();
		IUserBusinessService userService = (IUserBusinessService) bsFactory
				.getFactory().getBean("userBS");
		SuperUser superUser = new SuperUser();
		try {
			superUser = userService.getUserByKey(superUser, username);
			if (superUser != null) {
				this.password = superUser.getPassword();
			} else {
				this.password = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return new org.springframework.security.core.userdetails.User(username,
				password, true, true, true, true,
				makeGrantedAuthorities(username));
	}

	private GrantedAuthority[] makeGrantedAuthorities(String username) {
		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_SUPERVISOR");
		GrantedAuthority[] result = new GrantedAuthority[roles.size()];
		int i = 0;
		for (String role : roles) {
			result[i++] = new GrantedAuthorityImpl(role);
		}
		return result;
	}
}