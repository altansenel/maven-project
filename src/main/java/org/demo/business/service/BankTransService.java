/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.BankTrans;

/**
 * Business Service Interface for entity BankTrans.
 */
public interface BankTransService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	BankTrans findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<BankTrans> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	BankTrans save(BankTrans entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	BankTrans update(BankTrans entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	BankTrans create(BankTrans entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}