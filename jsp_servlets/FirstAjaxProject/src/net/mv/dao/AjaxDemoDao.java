package net.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjaxDemoDao {

	public void insertRecord(String name, String email, String comment) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String sql = "insert into AJAX(A_NAME, A_EMAIL, A_COMMENT)" + "values (?, ?, ?)";
		
		
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, comment);
			pstmt.execute();
			System.out.println("Record added to the database");
			System.out.println(name + ", " + email + ", " + comment);
			
		}
		catch(SQLException e){
			System.out.println("unable to get connection");
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch (SQLException e){
				System.out.println("connection not closed");
				e.printStackTrace();
			}
		}
	}

}
