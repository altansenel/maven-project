/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.StockCategory ;

/**
 * Very basic cache for StockCategory instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCategoryCache
{
	private final static Map<String,StockCategory> cache = new Hashtable<String,StockCategory>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given StockCategory instance in the cache
	 * @param StockCategory instance to be stored
	 */
	public final static void putStockCategory(StockCategory stockCategory ) {
		String key = getKey( stockCategory.getId() ) ;
		cache.put(key, stockCategory );
	}
	
	/**
	 * Get the StockCategory instance for the given primary key
     * @param id 
	 * @return the StockCategory instance (or null if none)
	 */
	public final static StockCategory getStockCategory( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the StockCategory associated with the given primary key
     * @param id 
	 */
	public final static void removeStockCategory ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given StockCategory from the cache using its primary key
	 * @param StockCategory instance to be removed
	 */
	public final static void removeStockCategory (StockCategory stockCategory ) { 
		String key = getKey( stockCategory.getId() ) ;
		cache.remove(key);
	}

}
