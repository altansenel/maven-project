/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.AdminWorkspace;

/**
 * Business Service Interface for entity AdminWorkspace.
 */
public interface AdminWorkspaceService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	AdminWorkspace findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<AdminWorkspace> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	AdminWorkspace save(AdminWorkspace entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminWorkspace update(AdminWorkspace entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminWorkspace create(AdminWorkspace entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
