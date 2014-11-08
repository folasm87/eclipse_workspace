package net.mv.process;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ProcessBean
 */

/*@LocalBean*/
@Stateless(name="process")
public class ProcessBean implements Process {
	
	@EJB
	private Email email;
	
	@EJB
	private Employee emp;
	
	@Resource
	private SessionContext xctx;

	@Override
	public void someProcess() {
		System.out.println("Processing...");
		emp.saveEmployee("George Jetson");
		email.sendMail("Mr.Sprockets");
		
	}

}
