package net.mv.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
//this class encapsulates the information typed in by the user for one form in your application
//this class is just a pojo (except it extends ActionForm)
public class RegisterForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758688865852821174L;
	//declare the variables from your jsp
	private String username;
	private String password;
	private String name;
	private String dob;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
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
		}else if((name==null) || name.length() < 4){
			errors.add("password", new ActionMessage("errors.name.required"));
		}else if((dob==null) || dob.length() < 4){
			errors.add("password", new ActionMessage("errors.dob.required"));
		}
		
		return errors;
		
	}

}
