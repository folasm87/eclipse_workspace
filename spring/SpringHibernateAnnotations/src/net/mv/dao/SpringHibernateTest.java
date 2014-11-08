package net.mv.dao;

import java.util.List;
import java.util.Iterator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class SpringHibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeDao ed = (EmployeeDao)ctx.getBean("employeeDaoImpl");
		
		/*Employee test1 = new Employee();
		test1.setId(101);
		test1.setName("Arion");
		test1.setAge(54);
		test1.setSalary(983153.1);
		System.out.println("Creating new employee...");
		
		Employee test2 = new Employee();
		test2.setId(102);
		test2.setName("Max");
		test2.setAge(37);
		test2.setSalary(10034.0);
		System.out.println("Creating new employee...");
		
		Employee test3 = new Employee();
		test3.setId(103);
		test3.setName("Josephine");
		test3.setAge(69);
		test3.setSalary(67454.0);
		System.out.println("Creating new employee...");
		
	
		ed.saveEmployee(test1);
		ed.saveEmployee(test2);
		ed.saveEmployee(test3);
		System.out.println("Done creating.");
		System.out.println("");*/
		
		
		//Retrieve
		int id = 101;
		Employee result = ed.getEmployee(id);
		System.out.println(result);
		
		int id2 = 100;
		Employee result2 = ed.getEmployee(id);
		System.out.println(result2);
	/*	System.out.println("Updating employee info");
		
		
		//Updating 
		result2.setSalary(3153151351.244);
		ed.updateEmployee(result2);
		System.out.println("Done updating");*/
		
		
		/*//Delete
		System.out.println("Deleting employee:");
		System.out.println(result);
		ed.deleteEmployee(result);*/
		
		
		double salary = 20000.0;
		List<?> list = ed.getAllEmployees(salary);
		Iterator<?> iter = list.iterator();
		while(iter.hasNext()){
			Employee blah = (Employee)iter.next();
			System.out.println();
		}
		

	}

}
