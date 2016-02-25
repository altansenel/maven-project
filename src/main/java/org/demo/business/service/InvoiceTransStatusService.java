/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.InvoiceTransStatus;

/**
 * Business Service Interface for entity InvoiceTransStatus.
 */
public interface InvoiceTransStatusService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	InvoiceTransStatus findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<InvoiceTransStatus> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	InvoiceTransStatus save(InvoiceTransStatus entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	InvoiceTransStatus update(InvoiceTransStatus entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	InvoiceTransStatus create(InvoiceTransStatus entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
