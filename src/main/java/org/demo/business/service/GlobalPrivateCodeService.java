/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.GlobalPrivateCode;

/**
 * Business Service Interface for entity GlobalPrivateCode.
 */
public interface GlobalPrivateCodeService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	GlobalPrivateCode findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<GlobalPrivateCode> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	GlobalPrivateCode save(GlobalPrivateCode entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	GlobalPrivateCode update(GlobalPrivateCode entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	GlobalPrivateCode create(GlobalPrivateCode entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
