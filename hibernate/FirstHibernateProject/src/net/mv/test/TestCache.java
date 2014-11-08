package net.mv.test;

import org.hibernate.Session;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Student;

public class TestCache {

	public static void main(String[] args) {
		Session session1 = HibernateUtility.getSessionFactory().openSession();
		Student stu1 = (Student)session1.load(Student.class, 1L);
		System.out.println(stu1);
		session1.close();
		System.out.println("closing session1");
		
		//go get the same record in a different session
		Session session2 = HibernateUtility.getSessionFactory().openSession();
		Student stu2 = (Student)session2.load(Student.class, 1L); 
		System.out.println(stu2);
		session2.close();
		System.out.println("closing session2");
	}

}
