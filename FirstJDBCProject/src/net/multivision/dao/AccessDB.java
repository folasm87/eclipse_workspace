package net.multivision.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDB 
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		// make a connection object(communication from java to database)
		Connection conn = null;
		//make URL String(where the database is)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//make SQL String
		String sql = "update students set first_name = 'Steve'"
					+ " where last_name = 'Smith'";
		
		
		String sql2 = "select * from STUDENTS WHERE LAST_NAME = 'Gates'";
		String sql3 = "insert into STUDENTS (FIRST_NAME, LAST_NAME, S_YEAR) values (?, ?, ?)";
		
		
		try //connecting to the db might fail
		{
		
			//Dont need to register the driver in this version
			
			//get the Connection object
			conn = DriverManager.getConnection(url, "core", "core"); //password
			
			//make statement object
			Statement stmt = conn.createStatement();
			
			//run the statement
			//stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery(sql2);
			
			while(rs.next()){
				System.out.print(rs.getString("FIRST_NAME") + " ");
				System.out.println(rs.getString("LAST_NAME"));
				
			}
			
			//make a PreparedStatement object
			PreparedStatement ps = conn.prepareStatement(sql3);
			ps.setString(1, args[0]);
			ps.setString(2, args[1]);
			ps.setInt(2, 3);
			ps.execute();
			//close the connection
			conn.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		} 
		
	}

}