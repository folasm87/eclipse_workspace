package net.mv.test;

import java.util.Iterator;
import java.util.List;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Animal;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TestAnimalCriteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		
		try{
			session = HibernateUtility.getSessionFactory().openSession();
			
			//Create a criteria object
			Criteria crit = session.createCriteria(Animal.class);
			crit.add(Restrictions.like("DIET", "Meat"));
			List list = crit.list();
			
			Iterator it = list.iterator();
			
			while(it.hasNext()){
				
				Animal a1 = (Animal)it.next();
				System.out.println(a1);
				System.out.println("<------------------->");
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}

	}

}
