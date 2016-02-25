/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.AdminSetting;

/**
 * Business Service Interface for entity AdminSetting.
 */
public interface AdminSettingService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	AdminSetting findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<AdminSetting> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	AdminSetting save(AdminSetting entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminSetting update(AdminSetting entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	AdminSetting create(AdminSetting entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}