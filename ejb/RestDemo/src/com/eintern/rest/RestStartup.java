package com.eintern.rest;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

//must go into project properties -> Java Compiler => Errors/Warnings => Deprecated and restricted API
//and set "forbidden reference" to "ignore"
public class RestStartup {

	static final String BASE_URI  = "http://localhost:9990/";
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		HttpServer server = HttpServerFactory.create(BASE_URI);
		server.start();
		System.out.println("Press Enter to stop server");
		System.in.read();
		server.stop(0);
	}

}
