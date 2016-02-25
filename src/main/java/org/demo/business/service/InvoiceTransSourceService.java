/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.InvoiceTransSource;

/**
 * Business Service Interface for entity InvoiceTransSource.
 */
public interface InvoiceTransSourceService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	InvoiceTransSource findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<InvoiceTransSource> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	InvoiceTransSource save(InvoiceTransSource entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	InvoiceTransSource update(InvoiceTransSource entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	InvoiceTransSource create(InvoiceTransSource entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
