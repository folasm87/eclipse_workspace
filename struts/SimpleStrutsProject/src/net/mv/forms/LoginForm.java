package net.mv.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
//this class encapsulates the information typed in by the user for one form in your application
//this class is just a pojo (except it extends ActionForm)
public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8866418794214767026L;
	
	//declare the variables from your jsp
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		//Create an ActionErrors object -> like a map(errorname, textToDisplay)
		
		ActionErrors errors = new ActionErrors();
		
		//logic to determine if there was an error when entering the form
		if((username==null) || username.length() < 4){
			
			errors.add("username", new ActionMessage("errors.username.required"));
		}else if((password==null) || password.length() < 4){
			errors.add("password", new ActionMessage("errors.password.required"));
		}
		
		return errors;
		
	}
	

}
