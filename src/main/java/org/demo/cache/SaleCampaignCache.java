/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.SaleCampaign ;

/**
 * Very basic cache for SaleCampaign instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class SaleCampaignCache
{
	private final static Map<String,SaleCampaign> cache = new Hashtable<String,SaleCampaign>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given SaleCampaign instance in the cache
	 * @param SaleCampaign instance to be stored
	 */
	public final static void putSaleCampaign(SaleCampaign saleCampaign ) {
		String key = getKey( saleCampaign.getId() ) ;
		cache.put(key, saleCampaign );
	}
	
	/**
	 * Get the SaleCampaign instance for the given primary key
     * @param id 
	 * @return the SaleCampaign instance (or null if none)
	 */
	public final static SaleCampaign getSaleCampaign( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the SaleCampaign associated with the given primary key
     * @param id 
	 */
	public final static void removeSaleCampaign ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given SaleCampaign from the cache using its primary key
	 * @param SaleCampaign instance to be removed
	 */
	public final static void removeSaleCampaign (SaleCampaign saleCampaign ) { 
		String key = getKey( saleCampaign.getId() ) ;
		cache.remove(key);
	}

}