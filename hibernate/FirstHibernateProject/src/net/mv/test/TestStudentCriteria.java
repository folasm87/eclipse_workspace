package net.mv.test;

import java.util.Iterator;
import java.util.List;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Student;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TestStudentCriteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		
		try{
			session = HibernateUtility.getSessionFactory().openSession();
			
			//Create a criteria object
			Criteria crit = session.createCriteria(Student.class);
			crit.add(Restrictions.like("sid", 2L));
			List list = crit.list();
			
			Iterator it = list.iterator();
			
			while(it.hasNext()){
				
				Student stu = (Student)it.next();
				System.out.println(stu);
				System.out.println("<------------------->");
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}

	}

}
