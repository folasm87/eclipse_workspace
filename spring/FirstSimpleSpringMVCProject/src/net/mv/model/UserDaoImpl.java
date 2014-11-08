package net.mv.model;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Inject
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

}
