package net.mv.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import net.mv.model.Employee;
import net.mv.model.EmployeeDao;
import net.mv.model.EmployeeDaoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blah")
public class DataController {

	@Inject
	private EmployeeDao employeeDaoImpl;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addEmployee(@Valid Employee employee, BindingResult result){
		
		if(result.hasErrors()){
			return "dataForm";	
		}else{
			try{
				employeeDaoImpl.saveEmployee(employee);
				return "success";
			}catch(DataAccessException e){
				
				e.printStackTrace();
				return "error";
			}
		}
	}
	
	//browsing to {Context Root}/blah causes this method to run
	@RequestMapping(method=RequestMethod.GET)
	public String displayCustomerForm(ModelMap model){
		model.addAttribute("employee", new Employee());
		return "dataForm";
	}
}
