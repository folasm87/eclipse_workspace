package net.mv.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("loginDao")
@Component
public class LoginDAO {

	@Inject
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean authenticate(String user, String pwd) {
		
		Login login = (Login)this.sessionFactory.getCurrentSession().get(Login.class, user);
		if(login == null){
			return false;//username doesn't exist
		}else{
			if(pwd.equals(login.getPassword()) ) //passwords match
					return true;
		}
		
		return false; //passwords don't match
	}

}
