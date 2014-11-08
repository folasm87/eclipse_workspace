package net.mv.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import net.mv.model.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {
	
	@Inject
	private UserDao userDaoImpl;
	
	@RequestMapping(value="registerSubmit", method=RequestMethod.POST)
	public String registerCustomer(@Valid User user, BindingResult result, ModelMap model){//, HttpServletRequest request){
		
		/*String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println(user + ": " + pass);
		
		model.addAttribute("username", user);
		
		return "login";*/
		
		if(result.hasErrors()){
			return "register";	
		}else{
			try{
				userDaoImpl.saveUser(user);
				return "login";
			}catch(DataAccessException e){
				
				e.printStackTrace();
				return "error";
			}
		}
		
	}

}
