package net.mv.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.AjaxDao;

import java.io.*;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8825533821759005200L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String balance2 = req.getParameter("balance");
		float balance = Float.parseFloat(balance2);
		AjaxDao dao = new AjaxDao();
		dao.insertRecord(username, password, first, last, balance);
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        
        out.println("<html>");
        out.println("<h2>User Successfully Added!</h2>");
		out.println("<body>");
		out.println("<a href='home.jsp'>Home</a>");
		out.println("<a href='add.jsp'>Add Another User</a>");
 		out.println("</body>");
 		out.println("</html>");
		out.close();
		
	} 
	
	

}
