/**
 * SpringDataModifierImpl.java
 */
package com.multivision.ehrms.crud.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.multivision.ehrms.crud.interfaces.ISpringDataModifier;
import com.multivision.ehrms.exception.DataSourceConnectivityFailedException;
import com.multivision.ehrms.exception.DuplicateRecordException;
import com.multivision.ehrms.exception.RecordRetrievalFailedException;

public class SpringDataModifierImpl implements ISpringDataModifier {
	Logger logger = Logger.getRootLogger();
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Object insertRecord(Object type) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		Object id = null;
		try {
			session.beginTransaction();
			session.save(type);
			id = session.getIdentifier(type);
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	/**
	 * Update record.
	 * 
	 * @param type
	 *            the type
	 * 
	 * @return the object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public Object updateRecord(Object type) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		Object id = null;
		try {
			session.beginTransaction();
			session.saveOrUpdate(type);
			id = session.getIdentifier(type);
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	/**
	 * Delete record.
	 * 
	 * @param type
	 *            the type
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void deleteRecord(Object type) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(type);
			session.flush();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * Delete by key.
	 * 
	 * @param type
	 *            the type
	 * @param keyName
	 *            the key name
	 * @param keyValue
	 *            the key value
	 * @param dataType
	 *            the data type
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void deleteByKey(Object type, String keyName, String keyValue,
			String dataType) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete from "
					+ type.getClass().getName() + " where " + keyName + "='"
					+ keyValue + "'");
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	
	public void deleteByMenu(Object type, String keyName, String keyValue,
			String dataType) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery("delete from Role_Menu_Access where system_id="+keyValue);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}


	/**
	 * Update bulk records.
	 * 
	 * @param objects
	 *            the objects
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("rawtypes")
	public void updateBulkRecords(List objects) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			for (int i = 0; i < objects.size(); i++) {
				Object type = objects.get(i);
				session.saveOrUpdate(type);
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			session.getTransaction().commit();
		} catch (org.hibernate.TransactionException ohtException) {
			session.getTransaction().rollback();
			logger.debug(this, ohtException);
			throw new DataSourceConnectivityFailedException(
					ohtException.getMessage());
		} catch (org.hibernate.exception.ConstraintViolationException cvException) {
			session.getTransaction().rollback();
			logger.debug(this, cvException);
			throw new DuplicateRecordException(cvException.getMessage());
		} catch (Exception exception) {
			session.getTransaction().rollback();
			logger.debug(this, exception);
			throw new RecordRetrievalFailedException(exception.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
