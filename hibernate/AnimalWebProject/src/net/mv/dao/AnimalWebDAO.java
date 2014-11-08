package net.mv.dao;

import org.hibernate.Session;

public class AnimalWebDAO {

	public static Animal lookup(String id) {
		Session session = null;
		
		session = HibernateUtility.getSessionFactory().openSession();
		//transaction?
		long l_id = Long.parseLong(id);
		System.out.println(l_id);
		Animal a1 = (Animal)session.get(Animal.class, l_id);
		
		session.close();
		return a1;
	}

}
