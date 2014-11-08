package net.mv.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.AjaxDao;

import java.io.*;
import java.util.HashMap;

public class DepositServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3473755915788748568L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String amount = req.getParameter("amount");
		String username = req.getParameter("username");
		String balance = req.getParameter("balance");
		AjaxDao dao = new AjaxDao();
		HashMap<String, String> map = dao.updateRecord(username, "", amount, balance);
		PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        
        out.println("<html>");
		
		out.println("<body>");
		out.println("<table border='3'>");
		out.println("<tr>");
		out.println("<td>Customer First Name</td>");
		out.println("<td>Customer Last Name</td>");
		out.println("<td>Customer Account Balance</td>");
		out.println("<tr>");
		out.println("<td>"+ map.get("first") + "</td>");
		out.println("<td>"+ map.get("last") + "</td>");
		out.println("<td>"+ map.get("balance") + "</td>");
		out.println("<tr>");
		out.println("</table>");
        out.println("<a href='home.jsp'>Go back</a>");
        System.out.println("Balance: " + map.get("balance"));
        out.println("<form action='deposit.do' method='post' id='deposit'><label for='desposit'> <input type='hidden' id='balance' value='" + map.get("balance")+ "'></input>Deposit: </label><input type='text' name='deposit' id='amount' /> <input type='submit' value='Deposit'></form> ");
        out.println("<form action='withdraw.do' method='post' id='withdraw'><label for='withdraw'><input type='hidden' id='balance' value='" + map.get("balance")+ "'></input> Withdraw: </label><input type='text' name='withdraw' id='amount' /> <input type='submit' value='Withdraw' id='withdraw'></form> ");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>");
        out.println("<script src='ajaxtodb.js'></script>");
 		out.println("</body>");
 		out.println("</html>");
		out.close();
		
	} 
	
	

}
