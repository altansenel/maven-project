/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.AdminUserRight ;

/**
 * Very basic cache for AdminUserRight instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminUserRightCache
{
	private final static Map<String,AdminUserRight> cache = new Hashtable<String,AdminUserRight>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given AdminUserRight instance in the cache
	 * @param AdminUserRight instance to be stored
	 */
	public final static void putAdminUserRight(AdminUserRight adminUserRight ) {
		String key = getKey( adminUserRight.getId() ) ;
		cache.put(key, adminUserRight );
	}
	
	/**
	 * Get the AdminUserRight instance for the given primary key
     * @param id 
	 * @return the AdminUserRight instance (or null if none)
	 */
	public final static AdminUserRight getAdminUserRight( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the AdminUserRight associated with the given primary key
     * @param id 
	 */
	public final static void removeAdminUserRight ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given AdminUserRight from the cache using its primary key
	 * @param AdminUserRight instance to be removed
	 */
	public final static void removeAdminUserRight (AdminUserRight adminUserRight ) { 
		String key = getKey( adminUserRight.getId() ) ;
		cache.remove(key);
	}

}