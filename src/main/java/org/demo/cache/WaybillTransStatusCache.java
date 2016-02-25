/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.WaybillTransStatus ;

/**
 * Very basic cache for WaybillTransStatus instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class WaybillTransStatusCache
{
	private final static Map<String,WaybillTransStatus> cache = new Hashtable<String,WaybillTransStatus>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given WaybillTransStatus instance in the cache
	 * @param WaybillTransStatus instance to be stored
	 */
	public final static void putWaybillTransStatus(WaybillTransStatus waybillTransStatus ) {
		String key = getKey( waybillTransStatus.getId() ) ;
		cache.put(key, waybillTransStatus );
	}
	
	/**
	 * Get the WaybillTransStatus instance for the given primary key
     * @param id 
	 * @return the WaybillTransStatus instance (or null if none)
	 */
	public final static WaybillTransStatus getWaybillTransStatus( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the WaybillTransStatus associated with the given primary key
     * @param id 
	 */
	public final static void removeWaybillTransStatus ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given WaybillTransStatus from the cache using its primary key
	 * @param WaybillTransStatus instance to be removed
	 */
	public final static void removeWaybillTransStatus (WaybillTransStatus waybillTransStatus ) { 
		String key = getKey( waybillTransStatus.getId() ) ;
		cache.remove(key);
	}

}
