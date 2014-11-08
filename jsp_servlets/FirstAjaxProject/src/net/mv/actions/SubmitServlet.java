package net.mv.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.AjaxDemoDao;

import java.io.*;



public class SubmitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3899498558668605781L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String comment = req.getParameter("comment");
		AjaxDemoDao dao = new AjaxDemoDao();
		dao.insertRecord(name, email, comment);
		
	} 

}
