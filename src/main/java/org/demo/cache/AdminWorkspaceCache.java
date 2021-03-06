/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.AdminWorkspace ;

/**
 * Very basic cache for AdminWorkspace instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminWorkspaceCache
{
	private final static Map<String,AdminWorkspace> cache = new Hashtable<String,AdminWorkspace>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given AdminWorkspace instance in the cache
	 * @param AdminWorkspace instance to be stored
	 */
	public final static void putAdminWorkspace(AdminWorkspace adminWorkspace ) {
		String key = getKey( adminWorkspace.getId() ) ;
		cache.put(key, adminWorkspace );
	}
	
	/**
	 * Get the AdminWorkspace instance for the given primary key
     * @param id 
	 * @return the AdminWorkspace instance (or null if none)
	 */
	public final static AdminWorkspace getAdminWorkspace( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the AdminWorkspace associated with the given primary key
     * @param id 
	 */
	public final static void removeAdminWorkspace ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given AdminWorkspace from the cache using its primary key
	 * @param AdminWorkspace instance to be removed
	 */
	public final static void removeAdminWorkspace (AdminWorkspace adminWorkspace ) { 
		String key = getKey( adminWorkspace.getId() ) ;
		cache.remove(key);
	}

}
