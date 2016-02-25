/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.GlobalCurrency;

/**
 * Business Service Interface for entity GlobalCurrency.
 */
public interface GlobalCurrencyService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	GlobalCurrency findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<GlobalCurrency> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	GlobalCurrency save(GlobalCurrency entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	GlobalCurrency update(GlobalCurrency entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	GlobalCurrency create(GlobalCurrency entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
