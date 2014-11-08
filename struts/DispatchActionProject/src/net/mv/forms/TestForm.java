package net.mv.forms;

//import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

public class TestForm extends ActionForm{
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		
		ActionErrors errors = new ActionErrors();
		
		if(test == null || test.length() < 1){
			
			errors.add("test", new ActionMessage("errors.test"));
		}
		
		return errors;
	}
	
	
}
	