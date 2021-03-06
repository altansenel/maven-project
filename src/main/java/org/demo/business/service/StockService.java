/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.Stock;

/**
 * Business Service Interface for entity Stock.
 */
public interface StockService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	Stock findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Stock> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Stock save(Stock entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Stock update(Stock entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Stock create(Stock entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
