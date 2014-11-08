package com.multivision.ehrms.crud.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

/**
 * The Class DBUtil.
 */
public class DBUtil {

	/**
	 * Filter records for key.
	 * 
	 * @param type
	 *            the type
	 * @param keyValue
	 *            the key value
	 * @param session
	 *            the session
	 * @param keyName
	 *            the key name
	 * @param idType
	 *            the id type
	 * @param criteria
	 *            the criteria
	 * 
	 * @return the criteria
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public Criteria filterRecordsForKey(Object type, String keyValue,
			Session session, String keyName, String idType, Criteria criteria)
			throws Exception {
		Criteria newCriteria = null;
		if (keyValue != null) {
			newCriteria = setCriteriaBasedOnDataType(type, keyValue, session,
					keyName, idType, criteria);
		}
		return newCriteria;
	}

	/**
	 * Sets the criteria based on data type.
	 * 
	 * @param type
	 *            the type
	 * @param keyValue
	 *            the key value
	 * @param session
	 *            the session
	 * @param keyName
	 *            the key name
	 * @param idType
	 *            the id type
	 * @param criteria
	 *            the criteria
	 * 
	 * @return the criteria
	 */
	private Criteria setCriteriaBasedOnDataType(Object type, String keyValue,
			Session session, String keyName, String idType, Criteria criteria) {
		Criteria newCriteria = null;
		if (idType.equalsIgnoreCase("long")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Long.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("int")
				|| idType.equalsIgnoreCase("integer")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Integer.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("byte")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Byte.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("string")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, keyValue.trim()));
		} else if (idType.equalsIgnoreCase("short")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Short.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("float")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Float.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("double")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Double.valueOf(keyValue.trim())));
		} else if (idType.equalsIgnoreCase("char")
				|| idType.equalsIgnoreCase("character")) {
			char keyChar = keyValue.charAt(0);
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Character.valueOf(keyChar)));
		} else if (idType.equalsIgnoreCase("boolean")) {
			newCriteria = session.createCriteria(type.getClass()).add(
					Restrictions.eq(keyName, Boolean.valueOf(keyValue.trim())));
		}
		return newCriteria;
	}

	/**
	 * Sets the criteria based on data type.
	 * 
	 * @param keyValue
	 *            the key value
	 * @param keyName
	 *            the key name
	 * @param idType
	 *            the id type
	 * 
	 * @return the simple expression
	 */
	public SimpleExpression setCriteriaBasedOnDataType(String keyValue,
			String keyName, String idType) {
		SimpleExpression simpleExpression = null;
		if (idType.equalsIgnoreCase("long")) {
			simpleExpression = Restrictions.eq(keyName,
					Long.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("int")
				|| idType.equalsIgnoreCase("integer")) {
			simpleExpression = Restrictions.eq(keyName,
					Integer.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("byte")) {
			simpleExpression = Restrictions.eq(keyName,
					Byte.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("string")) {
			simpleExpression = Restrictions.eq(keyName, keyValue.trim());
		} else if (idType.equalsIgnoreCase("short")) {
			simpleExpression = Restrictions.eq(keyName,
					Short.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("float")) {
			simpleExpression = Restrictions.eq(keyName,
					Float.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("double")) {
			simpleExpression = Restrictions.eq(keyName,
					Double.valueOf(keyValue.trim()));
		} else if (idType.equalsIgnoreCase("char")
				|| idType.equalsIgnoreCase("character")) {
			simpleExpression = Restrictions.eq(keyName, keyValue);
		} else if (idType.equalsIgnoreCase("boolean")) {
			simpleExpression = Restrictions.eq(keyName,
					Boolean.valueOf(keyValue.trim()));
		}
		return simpleExpression;
	}
}
