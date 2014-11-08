package net.mv.model;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

}
