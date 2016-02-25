/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.BankExpense;

/**
 * Business Service Interface for entity BankExpense.
 */
public interface BankExpenseService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	BankExpense findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<BankExpense> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	BankExpense save(BankExpense entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	BankExpense update(BankExpense entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	BankExpense create(BankExpense entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
