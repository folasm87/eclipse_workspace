package com.eintern.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.eintern.helloservice.Hello;
import com.eintern.helloservice.HelloService;
import com.eintern.helloservice.HelloServiceLocator;

public class Client {

	public static void main(String[] main) throws ServiceException, RemoteException{
		HelloService service  = new HelloServiceLocator();
		Hello port = service.getHello();
		String returnVal = port.sayHello("Chuckles");
		
		System.out.println(returnVal);
	}

}
