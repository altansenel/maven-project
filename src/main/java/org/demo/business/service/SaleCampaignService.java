/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.SaleCampaign;

/**
 * Business Service Interface for entity SaleCampaign.
 */
public interface SaleCampaignService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	SaleCampaign findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<SaleCampaign> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	SaleCampaign save(SaleCampaign entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	SaleCampaign update(SaleCampaign entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	SaleCampaign create(SaleCampaign entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}