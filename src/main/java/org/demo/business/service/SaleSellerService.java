/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.SaleSeller;

/**
 * Business Service Interface for entity SaleSeller.
 */
public interface SaleSellerService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	SaleSeller findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<SaleSeller> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	SaleSeller save(SaleSeller entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	SaleSeller update(SaleSeller entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	SaleSeller create(SaleSeller entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
