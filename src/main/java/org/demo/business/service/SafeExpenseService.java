/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.SafeExpense;

/**
 * Business Service Interface for entity SafeExpense.
 */
public interface SafeExpenseService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	SafeExpense findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<SafeExpense> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	SafeExpense save(SafeExpense entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	SafeExpense update(SafeExpense entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	SafeExpense create(SafeExpense entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}