/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.ChqbllDetailPartial ;

/**
 * Very basic cache for ChqbllDetailPartial instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllDetailPartialCache
{
	private final static Map<String,ChqbllDetailPartial> cache = new Hashtable<String,ChqbllDetailPartial>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given ChqbllDetailPartial instance in the cache
	 * @param ChqbllDetailPartial instance to be stored
	 */
	public final static void putChqbllDetailPartial(ChqbllDetailPartial chqbllDetailPartial ) {
		String key = getKey( chqbllDetailPartial.getId() ) ;
		cache.put(key, chqbllDetailPartial );
	}
	
	/**
	 * Get the ChqbllDetailPartial instance for the given primary key
     * @param id 
	 * @return the ChqbllDetailPartial instance (or null if none)
	 */
	public final static ChqbllDetailPartial getChqbllDetailPartial( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the ChqbllDetailPartial associated with the given primary key
     * @param id 
	 */
	public final static void removeChqbllDetailPartial ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given ChqbllDetailPartial from the cache using its primary key
	 * @param ChqbllDetailPartial instance to be removed
	 */
	public final static void removeChqbllDetailPartial (ChqbllDetailPartial chqbllDetailPartial ) { 
		String key = getKey( chqbllDetailPartial.getId() ) ;
		cache.remove(key);
	}

}
