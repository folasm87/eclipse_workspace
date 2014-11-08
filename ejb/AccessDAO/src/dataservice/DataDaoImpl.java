package dataservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataDaoImpl implements DataDao{

	@Override
	public String retrieveName(int id) {
		
		
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs = null;
		String name = null;
		
		try{
			
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();
			stmt = conn.createStatement();
			
			//Retrieve an existing account
			
			rs = stmt.executeQuery("SELECT * FROM employee WHERE id= " + id);
			
			while (rs.next()){
				name = rs.getString(2) + " " + rs.getString(3);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			try{
				
				rs.close();
				conn.close();
				stmt.close();
				
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return name;
		
	}

}
