/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.GlobalTransPoint ;

/**
 * Very basic cache for GlobalTransPoint instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class GlobalTransPointCache
{
	private final static Map<String,GlobalTransPoint> cache = new Hashtable<String,GlobalTransPoint>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given GlobalTransPoint instance in the cache
	 * @param GlobalTransPoint instance to be stored
	 */
	public final static void putGlobalTransPoint(GlobalTransPoint globalTransPoint ) {
		String key = getKey( globalTransPoint.getId() ) ;
		cache.put(key, globalTransPoint );
	}
	
	/**
	 * Get the GlobalTransPoint instance for the given primary key
     * @param id 
	 * @return the GlobalTransPoint instance (or null if none)
	 */
	public final static GlobalTransPoint getGlobalTransPoint( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the GlobalTransPoint associated with the given primary key
     * @param id 
	 */
	public final static void removeGlobalTransPoint ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given GlobalTransPoint from the cache using its primary key
	 * @param GlobalTransPoint instance to be removed
	 */
	public final static void removeGlobalTransPoint (GlobalTransPoint globalTransPoint ) { 
		String key = getKey( globalTransPoint.getId() ) ;
		cache.remove(key);
	}

}
