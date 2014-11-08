/**
 * SpringHibernateFactory.java
 */
package com.multivision.ehrms.crud.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateFactory {
	private static ApplicationContext context;
	private static final String APPLICATION_CONTEXT_FILE = "data-base-beans.xml";
	private static SpringHibernateFactory INSTANCE = new SpringHibernateFactory();

	private SpringHibernateFactory() {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE);
	}

	/**
	 * @return the iNSTANCE
	 */
	public static SpringHibernateFactory getInstance() {
		return INSTANCE;
	}

	public synchronized static ApplicationContext getContext() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(
					APPLICATION_CONTEXT_FILE);
		}
		return context;
	}

}
