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
	private String fname;
	private String lname;
	private String role;
	private String email;
	private String phone;
	
	
	
	
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




	public String getFname() {
		return fname;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}




	public String getLname() {
		return lname;
	}




	public void setLname(String lname) {
		this.lname = lname;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		//Create an ActionErrors object -> like a map(errorname, textToDisplay)
		
		ActionErrors errors = new ActionErrors();
		
		//logic to determine if there was an error when entering the form
		if((username==null) || username.length() < 2){
			
			errors.add("username", new ActionMessage("errors.username.required"));
		}else if((password==null) || password.length() < 2){
			errors.add("password", new ActionMessage("errors.password.required"));
		}else if((fname==null) || fname.length() < 2){
			errors.add("fname", new ActionMessage("errors.fname.required"));
		}else if((lname==null) || lname.length() < 2){
			errors.add("lname", new ActionMessage("errors.lname.required"));
		}
		
		return errors;
		
	}

}
