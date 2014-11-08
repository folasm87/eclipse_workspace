package com.eintern.restful.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConversionService")
public class Converter {
	
	@GET
	@Path("/InchToFeet/{i}")
	@Produces(MediaType.TEXT_PLAIN)
	public String convertInchToFeet(@PathParam("i") int i){
		
		double feet = 0;
		feet = (double)i/12;
		
		String str = feet + ""; 
		return str;
		
	}
	

}
