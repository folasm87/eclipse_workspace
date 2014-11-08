package net.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

public class AjaxDao {

	public void insertRecord(String username, String password, String first, String last, float balance) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into B_ACCOUNT(B_FIRST, B_LAST, B_USERN, B_PASSW, B_ACCBAL)" + "values (?, ?, ?, ?, ?)";
		
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, first);
			pstmt.setString(2, last);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setFloat(5, balance);
			pstmt.execute();
			System.out.println("Record added to the database");
			System.out.println(username + ": " + first + " " + last + " added " + balance + ".");
			
		}
		catch(SQLException e){
			System.out.println("unable to get connection");
			e.printStackTrace();
		}finally{
			try{
				if (pstmt != null){
					pstmt.close();
				}
				
				if (conn != null){
					conn.close();
				}
			}catch (SQLException e){
				System.out.println("connection not closed");
				e.printStackTrace();
			}
		}
	}

	
	
	public HashMap<String, String> retrieveRecord(String username, String password){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//String sql = "insert into B_ACCOUNT(B_FIRST, B_LAST, B_USERN, B_PASSW, B_ACCBAL)" + "values (?, ?, ?, ?, ?)";
		
		String sql = "SELECT B_FIRST, B_LAST, B_ACCBAL FROM B_ACCOUNT where B_USERN = ?"; //and B_PASSW = ?
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			//pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery(); 
			
			String firstname, lastname;
			float acc_balance;
			
			while (rs.next()) {
				 
				firstname = rs.getString("B_FIRST");
				lastname = rs.getString("B_LAST");
				String bal = rs.getString("B_ACCBAL");
				acc_balance = Float.parseFloat(bal);
				
				map.put("first", firstname);
				map.put("last", lastname);
				map.put("balance", bal);
 
				System.out.println("User Logged In!");
				System.out.println("Name: " + firstname + " " + lastname + ":" + ". Balance: " + acc_balance);
 
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if (pstmt != null){
					pstmt.close();
				}
				
				if (conn != null){
					conn.close();
				}
				
				
				
			}catch (SQLException e){
				System.out.println("connection not closed");
				e.printStackTrace();
			}
		}
		return map;
	}

	public HashMap<String, String> updateRecord(String username, String password, String amount, String balance) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = "UPDATE B_ACCOUNT SET B_ACCBAL = 'B_ACCBAL + ?'  where B_USERN = ?";
		String select_sql = "SELECT B_FIRST, B_LAST, B_ACCBAL FROM B_ACCOUNT where B_USERN = ?";
		
		System.out.println("Deposit Amount = " + amount + " Balance = " + balance);
		HashMap<String, String> map=new HashMap<String, String>();
		float balance2 = Float.parseFloat(balance);
		float amount2 = Float.parseFloat(amount);
		balance2 += amount2;
		System.out.println("DepositX Amount2 = " + amount2 + " Balance2 = " + balance2);
		
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, balance2);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(select_sql);
			pstmt2.setString(1, username);
			//pstmt.setString(2, password);
			
			ResultSet rs = pstmt2.executeQuery(); 
			
			String firstname, lastname;
			float acc_balance;
			
			while (rs.next()) {
				 
				firstname = rs.getString("B_FIRST");
				lastname = rs.getString("B_LAST");
				String bal = rs.getString("B_ACCBAL");
				acc_balance = Float.parseFloat(bal);
				
				map.put("first", firstname);
				map.put("last", lastname);
				map.put("balance", bal);
 
				System.out.println("User Logged In!");
				System.out.println("Name: " + firstname + " " + lastname + ":" + ". Balance: " + acc_balance);
 
			}
			
		}
		catch(SQLException e){
			System.out.println("unable to get connection");
			e.printStackTrace();
		}finally{
			try{
				if (pstmt != null){
					pstmt.close();
				}
				
				if (pstmt2 != null){
					pstmt2.close();
				}
				
				if (conn != null){
					conn.close();
				}
			}catch (SQLException e){
				System.out.println("connection not closed");
				e.printStackTrace();
			}
		}
		
		return map;
	}
}

