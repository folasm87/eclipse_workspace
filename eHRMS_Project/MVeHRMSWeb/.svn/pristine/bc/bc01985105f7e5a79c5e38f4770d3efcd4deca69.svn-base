package com.multivision.ehrms.service.data;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DataServiceFactory {
	private static DataServiceFactory instance = new DataServiceFactory();

	public static DataServiceFactory getInstance() {
		return instance;
	}

	/**
	 * Factory reads the data services components configured into the
	 * data-service-beans.xml file
	 * 
	 * @return
	 */
	public BeanFactory getFactory() {
		ClassPathResource res = new ClassPathResource("data-service-beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		return factory;
	}
}
