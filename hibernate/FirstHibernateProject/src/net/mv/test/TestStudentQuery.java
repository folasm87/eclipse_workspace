package net.mv.test;

import java.util.Iterator;
import java.util.List;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Student;

import org.hibernate.*;

public class TestStudentQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		
		
		try{
			session = HibernateUtility.getSessionFactory().openSession();
			
			//create an HQL string to select all columns form all rows from Student table
			
			String hql = "from Student student";//same as select * from Student
			
			//create a query object and store all rows in the query object
			Query query = session.createQuery(hql);
			
			//make sure to import list from java.util 
			//Store in a list to easily iterate through
			
			List list = query.list();
			
			Iterator it = list.iterator();
			
			while(it.hasNext()){
				Student stu = (Student)it.next();
				System.out.println(stu);
				System.out.println("<----------->");
			}
			
			session.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}

	}

}
