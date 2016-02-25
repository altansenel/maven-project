/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.TempContactAging;

/**
 * Business Service Interface for entity TempContactAging.
 */
public interface TempContactAgingService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	TempContactAging findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<TempContactAging> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	TempContactAging save(TempContactAging entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	TempContactAging update(TempContactAging entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	TempContactAging create(TempContactAging entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}