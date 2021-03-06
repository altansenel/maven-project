/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.StockTrans;

/**
 * Business Service Interface for entity StockTrans.
 */
public interface StockTransService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	StockTrans findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<StockTrans> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	StockTrans save(StockTrans entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockTrans update(StockTrans entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockTrans create(StockTrans entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
