package net.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

public class Dao {
	
	public ArrayList<String> retrieveRecords() {

		Connection conn = null;
		Statement stmt = null;
		String sql = "SELECT * FROM RECIPES";
		ArrayList<String> data = new ArrayList<String>();
		
		try{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				data.add(rs.getString("r_name"));
				data.add(rs.getString("r_type"));
				data.add(rs.getString("r_time"));
				data.add(rs.getString("r_servings"));
				data.add(rs.getString("r_ingredients"));
				data.add(rs.getString("r_directions"));
			}
			
		}
		catch(SQLException e){
			System.out.println("unable to get connection");
			e.printStackTrace();
		}finally{
			try{
				if (stmt != null){
					stmt.close();
				}
				
				if (conn != null){
					conn.close();
				}
			}catch (SQLException e){
				System.out.println("connection not closed");
				e.printStackTrace();
			}
		}
		
		return data;
	}

	public void insertRecord(String name, String type, String time, String servings, String ingredients, String directions) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into RECIPES(r_name, r_type, r_time, r_servings, r_ingredients, r_directions)" + "values (?, ?, ?, ?, ?, ?)";
		
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setString(3, time);
			pstmt.setString(4, servings);
			pstmt.setString(5, ingredients);
			pstmt.setString(6, directions);
			pstmt.execute();
			System.out.println("Record added to the database");
			System.out.println(name + ": " + type + ",  " + time + ",  " + directions + ".");
			
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

	
	public boolean retrieveLogin(String username, String password){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//String sql = "insert into B_ACCOUNT(B_FIRST, B_LAST, B_USERN, B_PASSW, B_ACCBAL)" + "values (?, ?, ?, ?, ?)";
		
		String sql = "SELECT r_username, r_password FROM R_Users where r_username=? AND r_password=?"; //and B_PASSW = ?
		
		//HashMap<String, String> map=new HashMap<String, String>();
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery(); 
			
			//String username, ;
			//float acc_balance;
			
			while (rs.next()) {
				 
			
				System.out.println("User Logged In!");
				return true;
 
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
		
		return false;
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

	public void insertUserRecord(String uname, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into R_USERS(r_username, r_password)" + "values (?, ?)";
		
		
		try{
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			pstmt.execute();
			System.out.println("Record added to the database");
			System.out.println("[" + uname + "] was added to the database.");
			
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
}

