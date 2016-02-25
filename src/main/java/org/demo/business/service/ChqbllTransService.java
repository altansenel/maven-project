/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.ChqbllTrans;

/**
 * Business Service Interface for entity ChqbllTrans.
 */
public interface ChqbllTransService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	ChqbllTrans findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<ChqbllTrans> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	ChqbllTrans save(ChqbllTrans entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	ChqbllTrans update(ChqbllTrans entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	ChqbllTrans create(ChqbllTrans entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
