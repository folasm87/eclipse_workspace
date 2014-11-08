/**
 * ISpringDataRetriever.java
 */
package com.multivision.ehrms.crud.interfaces;

import java.util.List;

import com.multivision.ehrms.business.Applicant;
import com.multivision.ehrms.business.Requirement;

public interface ISpringDataRetriever {

	public Object retrieveByKey(Object type, String keyValue) throws Exception;

	public Object retrieveByCompositeKey(Object type, Object key)
			throws Exception;

	public <T> List<T> retrieveByCriteria(Object type, String filterField,
			String filterValue, String dataType, String orderByColumn,
			boolean order) throws Exception;

	public <T> List<T> retrieveByCriteria(Object type, String filterField,
			String filterValue, String dataType) throws Exception;

	public <T> List<T> retrieveAllRecords(Object type) throws Exception;

	public <T> List<T> retrieveAllRecords(Object type, String orderByColumn,
			boolean order) throws Exception;

	public <T> List<T> retrieveByCriteria(List<?> criteriaList)
			throws Exception;

	public <T> List<T> retrieveByCriteria(List<?> criteriaList,
			String orderByColumn, boolean order) throws Exception;

	public List<Requirement> JobSearch(String position, String location,
			String skill, String employer) throws Exception;

	public List<Applicant> CandiateSearch(String jobId, String eligibility,
			String skill, String experience) throws Exception;

};
