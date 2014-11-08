import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.multivision.ehrms.dao.Employee;
import com.multivision.ehrms.business.Employees;






@WebService()
public class EmployeeAnniversary {
	
	@WebMethod()
	public String[] getCurrentMonthAnniversaryEmployeesName()
			throws RemoteException {
		String[] employeeNames = null;
		List<?> anniversaryEmployees = null;
		try {

			Properties pr = new Properties(); 
			pr.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory"); 
			pr.put(Context.PROVIDER_URL,"t3://localhost:7001"); 

			InitialContext ic = new InitialContext(pr);
			Object objref = ic.lookup("EmployeeBean#com.multivision.ehrms.business.Employees");
			Employees employees = (Employees)objref;
			anniversaryEmployees = employees.getCurrentMonthAnniversaryEmployees();
			
			Iterator<Employee> itr = (Iterator<Employee>) anniversaryEmployees.iterator();
			employeeNames = new String[anniversaryEmployees.size()];
			int i = 0;
			while (itr.hasNext()) {
				if (i < anniversaryEmployees.size()) {
					employeeNames[i] = ((Employee) itr.next()).getName();
				}
				i++;
			}

		} catch (Exception ex) {
			System.err.println("Caught an unexpected BC exception!");
			ex.printStackTrace();
		}
		return employeeNames;
	}
	
	

	
	
}
