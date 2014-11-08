package net.mv.business;

import javax.inject.Inject;

import net.mv.dao.LoginDAO;

import org.springframework.stereotype.Component;

//annotation to let the spring container know that this is a bean
@Component
public class BusinessDelegate {
	
	@Inject
	private LoginDAO lDao;
	
	public boolean loginDAO(String user, String pwd){
		//calls the dao class to check from DB
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/spring.xml");
		lDao = (LoginDAO)ctx.getBean("employeeDaoImpl");*/
		if(lDao.authenticate(user,pwd)){
			return true;
		}
		else return false;
	}
}
