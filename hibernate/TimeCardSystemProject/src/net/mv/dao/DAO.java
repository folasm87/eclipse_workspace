package net.mv.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAO {

	public static void insertUser(String username, String password,
			String fname, String lname, String superUser) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			System.out.println(username + ": " + fname + " " + lname);
			Transaction tx = session.beginTransaction();
			T_User user = new T_User();

			user.setT_USERNAME(username);
			//user.setUSERNAME(username);
			user.setPASSWORD(password);
			user.setFNAME(fname);
			user.setLNAME(lname);
			//user.setSuper_user(superUser);
			//user.setSuper_user(superUser);
			
			user.setSuper_user(superUser);
			System.out.println(user);

			session.saveOrUpdate(user);
			//session.flush();
			tx.commit();
			//session.close();

			// return true;

		} catch (Exception e) {
			e.printStackTrace();
			// return false;
		}
	}
	
	public static boolean insertTimesheet(int month, int day, int year, int start_hour, int start_min, int end_hour, int end_min, T_User user) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			System.out.println(user.getT_USERNAME() + " is starting the logging process");
			Transaction tx = session.beginTransaction();
			Timesheet t_sheet = new Timesheet();

			
			t_sheet.setMONTH(month);
			t_sheet.setDAY(day);
			t_sheet.setYEAR(year);
			t_sheet.setSTART_HOUR(start_hour);
			t_sheet.setSTART_MIN(start_min);
			t_sheet.setEND_HOUR(end_hour);
			t_sheet.setEND_MIN(end_min);
			
			
			Set<Timesheet> tsheets = user.getTimesheets();
			tsheets.add(t_sheet);
			user.setTimesheets(tsheets);
			t_sheet.setUser(user);
			
			
			//System.out.println("Logging: " + user);

			session.saveOrUpdate(t_sheet);
			//session.flush();
			tx.commit();
			//session.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// return false;
		}
		
		return false;
	}

	public static T_User retrieveUser(String username, String password) {

		Session session = null;
		T_User found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			System.out.println(username + ": " + password);
			//Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("from T_User where T_USERNAME = :username AND PASSWORD = :password ");
			
			query.setParameter("username", username);
			query.setParameter("password", password);
			//session.saveOrUpdate(user);
			List<?> list = query.list();
			
			found = (T_User)list.get(0);
			System.out.println("You retrieved the following user:");
			System.out.println(found);
			
			//data.add(found)
			session.flush();
			//tx.commit();
			session.close();

			//return true;

		} catch (Exception e) {
			e.printStackTrace();
			//return false;
		}
		
		return found;
	}

	public static List retrieveHours(T_User user) {
		Session session = null;
		List list = null;
		
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			//System.out.println(username + ": " + password);
	
			
			//Query query = session.createQuery("from T_User where T_USERNAME = :username AND PASSWORD = :password ");
			Query query = session.createQuery("from Timesheet where  T_USER_ID = :user_id");
			query.setParameter("user_id", user.getT_USER_ID());
			list = query.list();
			//return list;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
}
