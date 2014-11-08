package net.mv.process;

import javax.ejb.Stateless;

@Stateless
public class EmployeeBean implements Employee {

	@Override
	public void saveEmployee(String empName) {
		System.out.println("Saving employee: " + empName);
		
	}

}
