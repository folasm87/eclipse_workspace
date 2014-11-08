/**
 * SpringDataRetrieverImpl.java
 */
package com.multivision.ehrms.crud.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.metadata.ClassMetadata;

import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.FilterConditions;
import com.multivision.ehrms.business.Requirement;
import com.multivision.ehrms.crud.interfaces.ISpringDataRetriever;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.RecordRetrievalFailedException;

public class SpringDataRetrieverImpl implements ISpringDataRetriever {
	Logger logger = Logger.getRootLogger();
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Method to retrieve the database records through the primary key value of
	 * the given Object type.
	 * 
	 * @param type
	 *            the type
	 * @param keyValue
	 *            the key value
	 * 
	 * @return the object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public Object retrieveByKey(Object type, String keyValue) throws Exception {
		Object object = null;
		Session session = null;
		try {
			session = getCurrentSession();
			ClassMetadata classMetadata = getSessionFactory().getClassMetadata(
					type.getClass());
			String keyName = classMetadata.getIdentifierPropertyName();
			String idType = classMetadata.getIdentifierType().getName();
			Criteria criteria = null;

			session.beginTransaction();
			criteria = new DBUtil().filterRecordsForKey(type, keyValue,
					session, keyName, idType, criteria);
			object = criteria.uniqueResult();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return object;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Retrieve by composite key.
	 * 
	 * @param type
	 *            the type
	 * @param key
	 *            the key
	 * 
	 * @return the object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public Object retrieveByCompositeKey(Object type, Object key)
			throws Exception {
		Object object = null;
		return object;
	}

	/**
	 * Retrieve by criteria.
	 * 
	 * @param type
	 *            the type
	 * @param filterField
	 *            the filter field
	 * @param filterValue
	 *            the filter value
	 * @param dataType
	 *            the data type
	 * 
	 * @return the list
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings({ "rawtypes", "serial" })
	public List retrieveByCriteria(Object type, String filterField,
			String filterValue, String dataType, String orderByColumn,
			boolean order) throws Exception {
		List objects = null;
		Session session = null;
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria criteria = null;
			session.beginTransaction();
			criteria = new DBUtil().filterRecordsForKey(type, filterValue,
					session, filterField, dataType, criteria);
			objects = criteria.addOrder(new Order(orderByColumn, order) {
			}).list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objects;
	}

	@SuppressWarnings("rawtypes")
	public List retrieveByCriteria(Object type, String filterField,
			String filterValue, String dataType) throws Exception {
		List objects = null;
		Session session = getSessionFactory().getCurrentSession();
		try {
			Criteria criteria = null;
			session.beginTransaction();
			criteria = new DBUtil().filterRecordsForKey(type, filterValue,
					session, filterField, dataType, criteria);
			objects = criteria.list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objects;
	}

	/**
	 * Method to retrieve all the available records of the given type Object.
	 * 
	 * @param type
	 *            the type
	 * 
	 * @return the list
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("rawtypes")
	public List retrieveAllRecords(Object type) throws Exception {
		List objects = null;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			logger.info("Beginning retrieveAll session");
			Criteria criteria = session.createCriteria(type.getClass());
			objects = criteria.list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				logger.info("Ending retrieveAll session");
				session.close();
			}
		}
		
		logger.info("Returning objects");
		return objects;
	}

	@SuppressWarnings({ "rawtypes", "serial" })
	public List retrieveAllRecords(Object type, String orderByColumn,
			boolean order) throws Exception {
		List objects = null;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(type.getClass())
					.addOrder(new Order(orderByColumn, order) {
					});
			objects = criteria.list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objects;
	}

	/**
	 * Retrieve by criteria.
	 * 
	 * @param criteriaList
	 *            the criteria list
	 * 
	 * @return the list
	 * 
	 * @throws Exception
	 *             the exception
	 */

	@SuppressWarnings("rawtypes")
	public List retrieveByCriteria(List criteriaList) throws Exception {
		List objects = null;
		Session session = null;
		try {
			if (!criteriaList.isEmpty()) {
				session = getSessionFactory().getCurrentSession();
				FilterConditions filterConditions = (FilterConditions) criteriaList
						.get(0);
				session.beginTransaction();
				Criteria criteria = session.createCriteria(filterConditions
						.getObjType().getClass());

				int criteriaListSize = criteriaList.size();
				SimpleExpression simpleExpression = null;
				for (int i = 0; i < criteriaListSize; i++) {
					filterConditions = (FilterConditions) criteriaList.get(i);
					simpleExpression = new DBUtil().setCriteriaBasedOnDataType(
							filterConditions.getFilterValue(),
							filterConditions.getFilterField(),
							filterConditions.getDataType());
					criteria.add(simpleExpression);
				}
				objects = criteria.list();
				session.getTransaction().commit();
			}
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objects;
	}

	@SuppressWarnings({ "rawtypes", "serial" })
	public List retrieveByCriteria(List criteriaList, String orderByColumn,
			boolean order) throws Exception {
		List objects = null;
		Session session = null;
		try {
			if (!criteriaList.isEmpty()) {
				session = getSessionFactory().getCurrentSession();
				FilterConditions filterConditions = (FilterConditions) criteriaList
						.get(0);
				session.beginTransaction();
				Criteria criteria = session.createCriteria(filterConditions
						.getObjType().getClass());

				int criteriaListSize = criteriaList.size();
				SimpleExpression simpleExpression = null;
				for (int i = 0; i < criteriaListSize; i++) {
					filterConditions = (FilterConditions) criteriaList.get(i);
					simpleExpression = new DBUtil().setCriteriaBasedOnDataType(
							filterConditions.getFilterValue(),
							filterConditions.getFilterField(),
							filterConditions.getDataType());
					criteria.add(simpleExpression);
				}
				objects = criteria.addOrder(new Order(orderByColumn, order) {
				}).list();
				session.getTransaction().commit();
			}
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objects;
	}
	
	public List<Requirement> JobSearch(String position,String location,String skill,String employer) throws Exception {
		List<Requirement> jobList = new ArrayList<Requirement>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(Requirement.class)
					.add(Restrictions.or(
							Restrictions.like("positionName", "%"+position+"%"),
							Restrictions.like("location", "%"+location+"%")))
					.add(Restrictions.or(
							Restrictions.like("skillset", "%"+skill+"%"),
							Restrictions.like("clientName", "%"+employer+"%")));
			jobList = criteria.list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return jobList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Applicant> CandiateSearch(String jobId,String eligibility,String skill,String experience) throws Exception {
		List<Applicant> jobList = new ArrayList<Applicant>();
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(Applicant.class)
					.add(Restrictions.or(
							Restrictions.like("jobProfile", "%"+jobId+"%"),
							Restrictions.like("basicqualification", "%"+eligibility+"%")))
					.add(Restrictions.or(
							Restrictions.like("skillSet", "%"+skill+"%"),
							Restrictions.like("experience", "%"+experience+"%")));
			jobList = criteria.list();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return jobList;
	}


}
