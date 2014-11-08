package net.mv.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
@Repository("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
		
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return (Employee)this.sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().update(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().delete(employee);
		
	}

	@Override
	@Transactional
	public List<?> getAllEmployees(double salary) {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee where salary = " + salary).list();
		
	}

}
