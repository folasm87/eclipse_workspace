package dataservice;

import dataservice.Shopping;
import dataservice.HibernateUtility;

import org.hibernate.Session;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Session session = null;
			
			session = HibernateUtility.getSessionFactory().openSession();
			org.hibernate.Transaction hibTxn = null;
			hibTxn = session.getTransaction();
			hibTxn.begin();
			Shopping shop = new Shopping("Milk");
			session.save(shop);
			hibTxn.commit();
			session.close();
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Adding Error Caught");
			}
	}

}
