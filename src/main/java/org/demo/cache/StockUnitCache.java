/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.StockUnit ;

/**
 * Very basic cache for StockUnit instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockUnitCache
{
	private final static Map<String,StockUnit> cache = new Hashtable<String,StockUnit>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given StockUnit instance in the cache
	 * @param StockUnit instance to be stored
	 */
	public final static void putStockUnit(StockUnit stockUnit ) {
		String key = getKey( stockUnit.getId() ) ;
		cache.put(key, stockUnit );
	}
	
	/**
	 * Get the StockUnit instance for the given primary key
     * @param id 
	 * @return the StockUnit instance (or null if none)
	 */
	public final static StockUnit getStockUnit( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the StockUnit associated with the given primary key
     * @param id 
	 */
	public final static void removeStockUnit ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given StockUnit from the cache using its primary key
	 * @param StockUnit instance to be removed
	 */
	public final static void removeStockUnit (StockUnit stockUnit ) { 
		String key = getKey( stockUnit.getId() ) ;
		cache.remove(key);
	}

}