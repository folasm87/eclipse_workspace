package net.mv.dao;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DAO {
	
	public static boolean insertUser(String username, String password,
			String fname, String lname, String role, String email, String phone) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			System.out.println(username + ": " + fname + " " + lname);
			Transaction tx = session.beginTransaction();
			User user = new User();

			user.setUsername(username);
			user.setPassword(password);
			user.setFname(fname);
			user.setLname(lname);
			user.setRole(role);
			user.setEmail(email);
			user.setPhone(phone);
			
			System.out.println(user);

			session.saveOrUpdate(user);
			
			tx.commit();
			

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static User retrieveUser(String username, String password) {

		Session session = null;
		User found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			System.out.println(username + ": " + password);
			
			
			Query query = session.createQuery("from User where USERNAME = :username AND PASSWORD = :password ");
			
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			List<?> list = query.list();
			
			found = (User)list.get(0);
			System.out.println("You retrieved the following user:");
			System.out.println(found);
			
			
			session.flush();
			
			session.close();

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return found;
	}
	
	public static boolean insertContract(String name, String client,
			double funding, double chargedHours) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			Transaction tx = session.beginTransaction();
			Contract contract = new Contract();
			
			contract.setContract_id(Long.toString(contract.getID()));
			contract.setName(name);
			contract.setClient(client);
			contract.setFunding(funding);
			contract.setChargedHours(chargedHours);
			
			
			System.out.println(contract);

			session.saveOrUpdate(contract);
			
			tx.commit();
			

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Contract retrieveContract(String contract_id) {

		Session session = null;
		Contract found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			Query query = session.createQuery("from Contract where CONTRACT_ID = :contract_id");
			
			query.setParameter("contract_id", contract_id);
			
			
			List<?> list = query.list();
			
			found = (Contract)list.get(0);
			System.out.println("You retrieved the following contract:");
			System.out.println(found);
			
			
			session.flush();
			
			session.close();

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return found;
	}
	
	public static boolean insertProject(Contract contract, String name, String commissioner, double cost, String desc, String duration, 
			String startDate, String endDate, String issues, String category, String objective) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			Transaction tx = session.beginTransaction();
			Project project = new Project();
			project.setProj_id(Long.toString(project.getID()));
			project.setCategory(category);
			project.setCommissioner(commissioner);
			project.setCost(cost);
			project.setDesc(desc);
			project.setDuration(duration);
			project.setObjective(objective);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setIssues(issues);
			project.setName(name);
			project.setContract(contract);
			
			System.out.println(project);

			session.saveOrUpdate(project);
			
			tx.commit();
			

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Project retrieveProject(String project_id) {

		Session session = null;
		Project found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			
			Query query = session.createQuery("from Project where PROJECT_ID = :project_id ");
			
			query.setParameter("project_id", project_id);
			
			List<?> list = query.list();
			
			found = (Project)list.get(0);
			System.out.println("You retrieved the following project:");
			System.out.println(found);
			
			
			session.flush();
			
			session.close();

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return found;
	}
	
	public static boolean insertTask(String name, double duration, Project project) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			Transaction tx = session.beginTransaction();
			Task task = new Task();

			task.setTask_id(Long.toString(task.getID()));
			
			task.setName(name);
			task.setDuration(duration);
			task.setProject(project);
			
			System.out.println(task);

			session.saveOrUpdate(task);
			
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Task retrieveTask(String task_id) {

		Session session = null;
		Task found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			
			Query query = session.createQuery("from Task where TASK_ID = :task_id ");
			
			query.setParameter("task_id", task_id);
			
			List<?> list = query.list();
			
			found = (Task)list.get(0);
			System.out.println("You retrieved the following task:");
			System.out.println(found);
			
			
			session.flush();
			//tx.commit();
			session.close();

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return found;
	}
	
	public static boolean insertResource(String name, double cost, Project project) {

		Session session = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			Transaction tx = session.beginTransaction();
			Resource resource = new Resource();

			resource.setResource_id(Long.toString(resource.getID()));
			resource.setName(name);
			resource.setCost(cost);
			resource.setProject(project);
			
			System.out.println(resource);

			session.saveOrUpdate(resource);
			
			tx.commit();
			

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Resource retrieveResource(String resource_id) {

		Session session = null;
		Resource found = null;

		try {
			session = HibernateUtility.getSessionFactory().openSession();
			
			
			Query query = session.createQuery("from Resource where RESOURCE_ID = :resource_id ");
			
			query.setParameter("resource_id", resource_id);
			
			List<?> list = query.list();
			
			found = (Resource)list.get(0);
			System.out.println("You retrieved the following resource:");
			System.out.println(found);
			
			
			session.flush();
			
			session.close();

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return found;
	}
	
	
	
	

}
