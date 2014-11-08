package net.mv.process;

import javax.ejb.Local;

@Local
public interface Employee {
	
	void saveEmployee(String empName);

}
