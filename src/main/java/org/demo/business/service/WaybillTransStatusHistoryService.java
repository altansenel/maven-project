/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.WaybillTransStatusHistory;

/**
 * Business Service Interface for entity WaybillTransStatusHistory.
 */
public interface WaybillTransStatusHistoryService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	WaybillTransStatusHistory findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<WaybillTransStatusHistory> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	WaybillTransStatusHistory save(WaybillTransStatusHistory entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	WaybillTransStatusHistory update(WaybillTransStatusHistory entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	WaybillTransStatusHistory create(WaybillTransStatusHistory entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}