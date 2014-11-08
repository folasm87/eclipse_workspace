package com.multivision.ehrms.service.data;

import org.springframework.context.ApplicationContext;

import com.multivision.ehrms.crud.impl.SpringHibernateFactory;
import com.multivision.ehrms.crud.interfaces.ISpringDataModifier;
import com.multivision.ehrms.crud.interfaces.ISpringDataRetriever;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;

public class BaseDataService {

	public ISpringDataRetriever getDataRetriever() throws Exception {
		ApplicationContext shFactory = null;
		ISpringDataRetriever retriever = null;
		try {
			shFactory = SpringHibernateFactory.getContext();
			retriever = (ISpringDataRetriever) shFactory
					.getBean("dataRetriever");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new DataSourceConnectivityFailedException(
					"Datasource connectivity problem.");
		}
		return retriever;
	}

	public ISpringDataModifier getDataModifier() throws Exception {
		ApplicationContext shFactory = null;
		ISpringDataModifier modifier = null;
		try {
			shFactory = SpringHibernateFactory.getContext();
			modifier = (ISpringDataModifier) shFactory.getBean("dataModifier");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new DataSourceConnectivityFailedException(
					"Datasource connectivity problem.");
		}
		return modifier;
	}
}
