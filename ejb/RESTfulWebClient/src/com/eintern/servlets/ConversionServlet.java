package com.eintern.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ConversionServlet extends HttpServlet {

	private static final long serialVersionUID = -3237654133264738426L;
	private static final String REST_URI = "http://localhost:7001/RESTfulService";
	private static final String INCH_TO_FEET = "/ConversionService/InchToFeet/";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final String inches = req.getParameter("inches");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		WebResource convertService = service.path("rest").path(INCH_TO_FEET+inches);
		String feet = convertService.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		HttpSession session = req.getSession();
		session.setAttribute("inches", inches);
		session.setAttribute("feet", feet);
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/finish.jsp");
		rd.forward(req, resp);
		
	}
}
