package net.mv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
	@RequestMapping(value="/loginSubmit", method=RequestMethod.POST)
	public String loginCustomer(ModelMap model, HttpServletRequest request){
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println(user + ": " + pass);
		
		model.addAttribute("username", user);
		
		
		return "inbox";
	}
}
