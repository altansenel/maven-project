/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.StockCostingInventory;

/**
 * Business Service Interface for entity StockCostingInventory.
 */
public interface StockCostingInventoryService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	StockCostingInventory findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<StockCostingInventory> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	StockCostingInventory save(StockCostingInventory entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockCostingInventory update(StockCostingInventory entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	StockCostingInventory create(StockCostingInventory entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}