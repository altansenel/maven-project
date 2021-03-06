/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.StockBarcode;

/**
 * Business Service Interface for entity StockBarcode.
 */
public interface StockBarcodeService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	StockBarcode findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<StockBarcode> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	StockBarcode save(StockBarcode entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockBarcode update(StockBarcode entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockBarcode create(StockBarcode entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
