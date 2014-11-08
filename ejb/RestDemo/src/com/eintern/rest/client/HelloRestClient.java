package com.eintern.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloRestClient {


	static final String REST_URI = "http://localhost:9990";
	static final String GREET_HELLO = "greeting/hello";
	static final String GREET_GOODBYE = "greeting/bye";
	
	public static void main(String[] args) {
		
		String name = "John Doe";
		ClientConfig config = new DefaultClientConfig();
		
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		
		// http://localhost:9999/greeting/hello/John+Doe
		WebResource helloService = service.path(GREET_HELLO).path(name);
		// store the result of the WS (Web Service)  in a string (as a string)
		String txtOutput = helloService.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("Greet output as text: " + txtOutput);
		
		WebResource byeService = service.path(GREET_GOODBYE).path(name);
		String byeOutput = byeService.accept(MediaType.TEXT_XML).get(String.class);
		System.out.println("Greet output as XML: " + byeOutput);
		
		
	}

}
