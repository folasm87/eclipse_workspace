package net.mv.test;

import net.mv.dao.HibernateUtility;
import net.mv.dao.Animal;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestAnimal {
	
	public static void main(String[] args){
		
		Session session = null;
		
		
		try{
			//use HibernateUtility class to get the session (connect to the db)
			//this is the factory design pattern
			
			session = HibernateUtility.getSessionFactory().openSession();
			
			//Begin a transaction
			Transaction tx = session.beginTransaction();
			
			//insert a record
			//create an object of type Animal and call the setters to set the values
			
			
			
			//====Animal [1]======
			Animal a1 = new Animal();
			
			a1.setAge(13);
			a1.setLimbs(4);
			a1.setDiet("Meat");
			a1.setType("Dog");
			a1.setName("Rover");
			a1.setOwner("Mark");
			
			
			System.out.print(a1);
			
			
			session.saveOrUpdate(a1);
			//session.flush();
			//tx.commit();
			//====End======
			
			
			//====Animal [2]======
			Animal a2 = new Animal();
			
			a2.setAge(9);
			a2.setLimbs(4);
			a2.setDiet("Meat");
			a2.setType("Cat");
			a2.setName("Ally");
			a2.setOwner("Mark");
			
			
			System.out.print(a2);
			
			
			session.saveOrUpdate(a2);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [3]======
			Animal a3 = new Animal();
			
			a3.setAge(2);
			a3.setLimbs(4);
			a3.setDiet("Meat");
			a3.setType("Rat");
			a3.setName("Zigut");
			a3.setOwner("Dianne");
			
			
			System.out.print(a3);
			
			
			session.saveOrUpdate(a3);
			//session.flush();
			//tx.commit();
			//====End======
			
			
			//====Animal [4]======
			Animal a4 = new Animal();
			
			a4.setAge(6);
			a4.setLimbs(4);
			a4.setDiet("Nuts");
			a4.setType("Parrot");
			a4.setName("Aleck");
			a4.setOwner("Bruno");
			
			
			System.out.print(a4);
			
			
			session.saveOrUpdate(a4);
			//session.flush();
			//tx.commit();
			//====End======
			
			
			//====Animal [5]======
			Animal a5 = new Animal();
			
			a5.setAge(11);
			a5.setLimbs(4);
			a5.setDiet("Meat");
			a5.setType("Wolf");
			a5.setName("Bane");
			a5.setOwner("Mel");
			
			
			System.out.print(a5);
			
			
			session.saveOrUpdate(a5);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [6]======
			Animal a6 = new Animal();
			
			a6.setAge(13);
			a6.setLimbs(4);
			a6.setDiet("Meat");
			a6.setType("Crow");
			a6.setName("All Father");
			a6.setOwner("Jenne");
			
			
			System.out.print(a6);
			
			
			session.saveOrUpdate(a6);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [7]======
			Animal a7 = new Animal();
			
			a7.setAge(14);
			a7.setLimbs(1);
			a7.setDiet("Anything");
			a7.setType("Dolphin");
			a7.setName("George");
			a7.setOwner("Aquatic Parks Ltd.");
			
			
			System.out.print(a7);
			
			
			session.saveOrUpdate(a7);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [8]======
			Animal a8 = new Animal();
			
			a8.setAge(8);
			a8.setLimbs(4);
			a8.setDiet("Anything");
			a8.setType("Honey Badger");
			a8.setName("King");
			a8.setOwner("None can tame him...");
			
			
			System.out.print(a8);
			
			
			session.saveOrUpdate(a8);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [9]======
			Animal a9 = new Animal();
			
			a9.setAge(44);
			a9.setLimbs(6);
			a9.setDiet("Meat");
			a9.setType("Dragon");
			a9.setName("Valerion");
			a9.setOwner("Danny");
			
			
			System.out.print(a9);
			
			
			session.saveOrUpdate(a9);
			//session.flush();
			//tx.commit();
			//====End======
			
			//====Animal [10]======
			Animal a10 = new Animal();
			
			a10.setAge(23);
			a10.setLimbs(4);
			a10.setDiet("Plants");
			a10.setType("Turtle");
			a10.setName("Danger");
			a10.setOwner("Megan");
			
			
			System.out.print(a10);
			
			
			session.saveOrUpdate(a10);
			//====End======
			
			session.flush();
			tx.commit();
			
			
			session.close();
			
			
		}catch(Exception e){
			System.out.println("Connection to the DB failed!");
			e.printStackTrace();
		}
		
	}

}
