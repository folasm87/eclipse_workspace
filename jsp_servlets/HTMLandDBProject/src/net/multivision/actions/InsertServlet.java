package net.multivision.actions;

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String stud_id = req.getParameter("s_id"); // must match name attribute
													// in html
		String first_name = req.getParameter("first_name");
		
		String last_name = req.getParameter("last_name");
		
		String s_year_s = req.getParameter("s_year");
		
		int s_year = Integer.parseInt(s_year_s);
		
		System.out.println(first_name + " " + last_name + " has a an id of " + stud_id + " and is in year " + s_year + "."); // print out values entered from
												// user
		
		
		Connection conn = null;
		
		String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
        
        try {
			Class.forName(DB_DRIVER);
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "core", "core"); 
            Statement stmt = conn.createStatement();
            
            String sql_insert = "INSERT INTO students (S_ID, FIRST_NAME, LAST_NAME, S_YEAR) values ('" + stud_id + "', '" +  first_name + "', '" + last_name + "', '" + s_year + "')";
            System.out.println(sql_insert);
            stmt.executeUpdate(sql_insert);
            
            String sql_select = "SELECT * FROM Students";
            
            ResultSet rs = stmt.executeQuery(sql_select);
            
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            
            out.println("<html>");
    		
    		out.println("<body>");
    		out.println("<table border='3'>");
    		out.println("<tr>");
    		out.println("<td>Student ID:</td>");
    		out.println("<td>First Name:</td>");
    		out.println("<td>Last Name:</td>");
    		out.println("<td>Year:</td>");
    		out.println("</tr>");
            while(rs.next()){
            	
            	
            	
            	out.println("<tr>");
        		out.println("<td>"+ rs.getString("s_id") + "</td>");
        		out.println("<td>"+ rs.getString("first_name") + "</td>");
        		out.println("<td>"+ rs.getString("last_name") + "</td>");
        		out.println("<td>"+ rs.getString("s_year") + "</td>");
        		out.println("</tr>");
        		

        		
            	
            }
            out.println("</table>");
            out.println("<a href='insert.html'>Go back</a>");
    		out.println("</body>");
    		out.println("</html>");
            out.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}
