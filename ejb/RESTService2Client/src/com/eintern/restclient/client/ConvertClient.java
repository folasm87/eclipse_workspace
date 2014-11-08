package com.eintern.restclient.client;


import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class ConvertClient {
	
	static final String REST_URI = "http://localhost:7001/RESTService2";
	static final String YARDS_TO_METERS = "/ConvertService/YardsToMeters/";

	public static void main(String[] args) {
		
		int yards = 12;
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		WebResource convertService = service.path("rest").path(YARDS_TO_METERS + yards);
		System.out.println("Convert yards to meters XML" + getOutputAsXml(convertService));
		
	}

	private static String getOutputAsXml(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
		
	}

}
