package net.multivision.dao;


import java.io.*;
import java.util.*;
import java.sql.*;



/*
 * Author: Mark Folashade
 * 


//Instructions//
-create a text file called studentin.txt with the information above
-Read the file using Java IO
-first line is the table name
-second line is information to create table using JAVA
-remaining lines are rows you will insert into the table using JAVA
-select all rows who have a 'n' in their name somewhere and add their fees and display total 
in console
-write these rows to a text file called studentout.txt
 * */


public class IoDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		
		File out = new File("src/net/multivision/dao/studentout.txt");
		out.createNewFile();
		FileWriter fw;
		BufferedWriter bw;
		
		File file = new File("src/net/multivision/dao/studentin.txt");
		FileReader fr;
		BufferedReader br;
		Connection conn = null;
		
		String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(DB_DRIVER);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "core", "core"); //password
		
		//make statement object
		Statement stmt = conn.createStatement();
		
		
		String sql_table = "create table ";
		String sql_insert = "INSERT INTO ";
		String find_sql = "SELECT * FROM ";
		ArrayList<String> inserts = new ArrayList<String>();
		try{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(out);
			bw = new BufferedWriter(fw);
			
			int line_count = 0;
			String line = null;
	
			while(true){
				
				line = br.readLine();
				
				line_count += 1;
				
				if (line == null){
					break;
				}
				
				if (line_count == 1){
					sql_table = sql_table + line + "(";
					sql_insert = sql_insert + line + "";
					find_sql += line + " WHERE STUDNAME like '%n%'";
				}else if (line_count == 2){
					
					ArrayList<String> col_name = new ArrayList<String>();
					ArrayList<String> col_type = new ArrayList<String>();
					ArrayList<String> col_size = new ArrayList<String>();
					
					
					String[] table_info = line.split(":");
					int line_len = table_info.length;
					int j, k;
					
					for (int i = 0; i < line_len; i+=3){
						j = i+1;
						k = i+2;
						col_name.add(table_info[i]);
						
						if (j < line_len){
							col_type.add(table_info[j]);
						}
						if (k < line_len){
							col_size.add(table_info[k]);
						}
					}
					
					
					Iterator<String> iter1 = col_name.iterator();
					Iterator<String> iter2 = col_type.iterator();
					Iterator<String> iter3 = col_size.iterator();
					
					
					String properties = "";
					
					while (iter1.hasNext() && iter2.hasNext() && iter3.hasNext()){
						String temp1 = iter1.next();
						String temp2 = iter2.next();
						String temp3 = iter3.next();
						properties = properties + temp1 + " " + temp2 + "(" + temp3 + ")";
						
						if(iter1.hasNext()){
							properties += ", ";
						
						}
					}
					
					properties += ")";
					System.out.println(properties);
					
					sql_table = sql_table +  properties;
					
					System.out.println(sql_table);
					System.out.println(sql_insert);
				
				}else{
					
					String[] insert_info = line.split(":");
					String insert_field = "";
					for(int k = 0; k < insert_info.length; k++){
						
						if ((k + 1) < insert_info.length)
							insert_field += "'" + insert_info[k] + "'" + ", ";
						else{
							insert_field += insert_info[k];
						}
					}
					
					String ins_stmt = sql_insert + " (STUDID, STUDNAME, DOB, FEES) values (" + insert_field + ")";
					inserts.add(ins_stmt);
					
				}
				
				
			}
			
			//Create Table
			stmt.executeQuery(sql_table);
			
			
			//Insert students into student table
			Iterator<String> ins_iter = inserts.iterator();
			while(ins_iter.hasNext()){
				stmt.executeUpdate(ins_iter.next());
			}
			
			
			System.out.println(find_sql);
			ResultSet rs = stmt.executeQuery(find_sql);
			
			float total = 0;
			String info = "";
			
			//Write to file
			while(rs.next()){ 
				float fee = rs.getFloat("fees");
				String studname = rs.getString("studname");
				String dob = rs.getString("dob");
				String id = rs.getString("studid");
				total += fee;
				info = studname + " is a student with an id of "+ id + ", who was born on " + dob + ", whose fee was " + fee + ".";
				System.out.println(info);
				bw.write(info);	
				bw.newLine();
			}
			bw.flush();
			bw.close();
			rs.close();
			
			System.out.println("The total Student Fees for Students that have an 'n' in their name  = " + total);
		}catch(IOException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (stmt != null){
				stmt.close();
			}
		}
		
		
	}

}
