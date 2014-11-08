package com.multivision.ehrms.service.business;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BusinessServiceFactory {

	private static final BusinessServiceFactory INSTANCE = new BusinessServiceFactory();

	public static BusinessServiceFactory getInstance() {
		return INSTANCE;
	}

	public BeanFactory getFactory() {
		ClassPathResource res = new ClassPathResource(
				"business-service-beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		return factory;
	}
}
