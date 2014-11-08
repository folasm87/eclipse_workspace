package net.mv.test;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestStudent {
	
	public static void main(String[] args){
		
		Session session = null;
		
		
		try{
			//use HibernateUtility class to get the session (connect to the db)
			//this is the factory design pattern
			
			session = HibernateUtility.getSessionFactory().openSession();
			
			//Begin a transaction
			Transaction tx = session.beginTransaction();
			
			//insert a record
			//create an object of type student and call the setters to set the values
			Student stu = new Student();
			
			stu.setFname("Stu45");
			stu.setLname("Armstrong");
			stu.setEmail("stu@armstrong.com");
			stu.setAge(18);
			System.out.print(stu);
			
			
			session.saveOrUpdate(stu);//hibernate, here' the object I'd like to send across
			session.flush();//send the object to Hibernate
			
			//retrieve
			long id = 5L;
			System.out.println("retrieving email for id = " + id);
			
			//populated Student object with the row from the db that has id = 5
			Student stu2 = (Student) session.get(Student.class, id);
			//print out the email address for this record
			System.out.println(stu2.getEmail() + " is the email returned");
			
			//update student
			stu2.setEmail("love@AOL.com");
			System.out.println(stu2);
			
			//deleting student
			session.delete(stu2);
			
			tx.commit();//send the object from Hibernate to the DB
			session.close();
			
			
		}catch(Exception e){
			System.out.println("Connection to the DB failed!");
			e.printStackTrace();
		}
		
	}

}
