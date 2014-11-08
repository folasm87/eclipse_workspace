package net.mv.actions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.AjaxDao;

import java.io.*;
import java.util.HashMap;

@WebServlet(name="login",urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4856787742693514128L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AjaxDao dao = new AjaxDao();
		HashMap<String, String> map = dao.retrieveRecord(username, password);
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
        out.println("<form action='deposit.do' method='post' id='deposit'><label for='desposit'> <input type='hidden' id='balance' value='" + map.get("balance")+ "'></input>Deposit: </label><input type='text' name='deposit' id='amount' /> <input type='submit' value='Deposit' id='deposit'></form> ");
        out.println("<form action='withdraw.do' method='post' id='withdraw'><label for='withdraw'><input type='hidden' id='balance' value='" + map.get("balance")+ "'></input> Withdraw: </label><input type='text' name='withdraw' id='amount' /> <input type='submit' value='Withdraw' id='withdraw'></form> ");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>");
        out.println("<script src='ajaxtodb.js'></script>");
 		out.println("</body>");
 		out.println("</html>");
		out.close();
	} 

}
