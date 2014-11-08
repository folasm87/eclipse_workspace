package net.mv.dao;

import java.util.List;
public interface EmployeeDao {
	
	public void saveEmployee(final Employee employee);
	
	public Employee getEmployee(int id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public List<?> getAllEmployees(final double salary);

}
