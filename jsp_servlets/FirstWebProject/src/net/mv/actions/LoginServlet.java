package net.mv.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		RequestDispatcher rd;
		//this will maintain "memory" about the user of our webpage
		HttpSession session = req.getSession();
		
		if(username.equals("John") && password.equals("pwd")){//hardcoding the username and password
			session.setAttribute("user", username);//toss the username into session
			rd = req.getRequestDispatcher("/welcome.jsp");//move to welcome.jsp
			rd.forward(req, resp);//forward along the information
		}else{//they fail login
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}
}
