/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.AdminDocumentTarget ;

/**
 * Very basic cache for AdminDocumentTarget instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminDocumentTargetCache
{
	private final static Map<String,AdminDocumentTarget> cache = new Hashtable<String,AdminDocumentTarget>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given AdminDocumentTarget instance in the cache
	 * @param AdminDocumentTarget instance to be stored
	 */
	public final static void putAdminDocumentTarget(AdminDocumentTarget adminDocumentTarget ) {
		String key = getKey( adminDocumentTarget.getId() ) ;
		cache.put(key, adminDocumentTarget );
	}
	
	/**
	 * Get the AdminDocumentTarget instance for the given primary key
     * @param id 
	 * @return the AdminDocumentTarget instance (or null if none)
	 */
	public final static AdminDocumentTarget getAdminDocumentTarget( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the AdminDocumentTarget associated with the given primary key
     * @param id 
	 */
	public final static void removeAdminDocumentTarget ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given AdminDocumentTarget from the cache using its primary key
	 * @param AdminDocumentTarget instance to be removed
	 */
	public final static void removeAdminDocumentTarget (AdminDocumentTarget adminDocumentTarget ) { 
		String key = getKey( adminDocumentTarget.getId() ) ;
		cache.remove(key);
	}

}
