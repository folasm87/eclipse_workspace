package dataservice;

import org.hibernate.Session;

public class ShoppingDAOImpl implements ShoppingDAO {

	public ShoppingDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(String id) {
		
		try {
		Session session = null;
		
		session = HibernateUtility.getSessionFactory().openSession();
		org.hibernate.Transaction hibTxn = null;
		hibTxn = session.getTransaction();
		hibTxn.begin();
		Shopping shop = new Shopping(id);
		session.save(shop);
		hibTxn.commit();
		session.close();
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Adding Error Caught");
		}
		
/*		long l_id = Long.parseLong(id);
		System.out.println(l_id);
		Shopping a1 = (Shopping)session.get(Shopping.class, l_id);*/
		
		
		//return a1;

	}

}
