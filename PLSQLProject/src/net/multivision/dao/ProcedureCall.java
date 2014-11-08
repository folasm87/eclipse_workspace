package net.multivision.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ProcedureCall {

	public static void main(String[] args) {
		Connection conn = null;
		//this is a Java class that knows how to call procedures
		//or anything else written in PL/SQL
		CallableStatement cstmt = null;
		
		
		try{
			conn = ConnectionFactory.getConnection();
			
			//change the last name of a Student
			//this is PL/SQL
			String SQL = "{call SET_LAST_NAME(?, ?)}";
			cstmt = conn.prepareCall(SQL);
			cstmt.setString(1, "Kennedy");
			cstmt.setString(2, "Bill");
			System.out.println("Changing last name...");
			cstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("Cleaning up...");
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
