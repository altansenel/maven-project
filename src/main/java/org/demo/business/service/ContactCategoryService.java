/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.ContactCategory;

/**
 * Business Service Interface for entity ContactCategory.
 */
public interface ContactCategoryService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	ContactCategory findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<ContactCategory> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	ContactCategory save(ContactCategory entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	ContactCategory update(ContactCategory entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	ContactCategory create(ContactCategory entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
