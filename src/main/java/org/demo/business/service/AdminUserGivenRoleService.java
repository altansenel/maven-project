/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.AdminUserGivenRole;

/**
 * Business Service Interface for entity AdminUserGivenRole.
 */
public interface AdminUserGivenRoleService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	AdminUserGivenRole findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<AdminUserGivenRole> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	AdminUserGivenRole save(AdminUserGivenRole entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminUserGivenRole update(AdminUserGivenRole entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminUserGivenRole create(AdminUserGivenRole entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
