/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.OrderTransFactor;

/**
 * Business Service Interface for entity OrderTransFactor.
 */
public interface OrderTransFactorService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	OrderTransFactor findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<OrderTransFactor> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	OrderTransFactor save(OrderTransFactor entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	OrderTransFactor update(OrderTransFactor entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	OrderTransFactor create(OrderTransFactor entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
