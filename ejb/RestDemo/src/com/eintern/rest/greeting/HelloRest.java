package com.eintern.rest.greeting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//this means that when you go to "http://localhost:9999/greeting" you'll get to this WS
@Path("/greeting")

public class HelloRest {
	
	@GET //what method (or how?)
	@Path("/hello/{name}") //where to go to sayHello()
	@Produces(MediaType.TEXT_PLAIN) //what is returned
	public String sayHello(@PathParam("name") String name){
		
		return "Hello " + name;
	}
	
	@GET //what method (or how?)
	@Path("/bye/{name}") //where to go to sayHello()
	@Produces(MediaType.TEXT_XML) //what is returned
	public String sayBye(@PathParam("name") String name){
		return "\n<?xml version='1.0' encoding='UTF-8'?>\n" + "<result>\n" + name + "</result>/n";
		
	}

}
