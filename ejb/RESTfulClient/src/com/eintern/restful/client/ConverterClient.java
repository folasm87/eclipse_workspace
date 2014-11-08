package com.eintern.restful.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ConverterClient {

	static final String REST_URI = "http://localhost:7001/RESTfulService";
	static final String INCH_TO_FEET = "/ConversionService/InchToFeet/";
	
	public static void main(String[] args) {
		int inch = 12;
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
		WebResource convertService = service.path("rest").path(INCH_TO_FEET+inch);
		System.out.println("Convert inches to feet XML" + getOutputAsXml(convertService));
	}

	private static String getOutputAsXml(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}

}
