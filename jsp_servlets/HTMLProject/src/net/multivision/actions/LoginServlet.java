package net.multivision.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	String user = req.getParameter("username"); //must match name attribute in html
	String pass = req.getParameter("password");

	System.out.println("User is: "+user); //print out values entered from user
	System.out.println("Password is: "+pass);
	System.out.println("Hi, I'm a servlet!");

	//create a request dispatcher object
	/*RequestDispatcher rd;

	rd = req.getRequestDispatcher("/inbox.html"); //where to next?

	//does the actual forwarding
	rd.forward(req, resp);*/

	//dynamically create the next page
	//create an out object of type PrintWriter by calling the getWriter method in the response
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	//out.println("<body bgcolor = 'blue'>");
	out.println("<body>");
	out.println(user+" logged in successfully!");
	out.println("</body>");
	out.println("</html>");

	out.close();
	}
}
