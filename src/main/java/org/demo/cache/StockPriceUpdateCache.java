/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.StockPriceUpdate ;

/**
 * Very basic cache for StockPriceUpdate instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockPriceUpdateCache
{
	private final static Map<String,StockPriceUpdate> cache = new Hashtable<String,StockPriceUpdate>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given StockPriceUpdate instance in the cache
	 * @param StockPriceUpdate instance to be stored
	 */
	public final static void putStockPriceUpdate(StockPriceUpdate stockPriceUpdate ) {
		String key = getKey( stockPriceUpdate.getId() ) ;
		cache.put(key, stockPriceUpdate );
	}
	
	/**
	 * Get the StockPriceUpdate instance for the given primary key
     * @param id 
	 * @return the StockPriceUpdate instance (or null if none)
	 */
	public final static StockPriceUpdate getStockPriceUpdate( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the StockPriceUpdate associated with the given primary key
     * @param id 
	 */
	public final static void removeStockPriceUpdate ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given StockPriceUpdate from the cache using its primary key
	 * @param StockPriceUpdate instance to be removed
	 */
	public final static void removeStockPriceUpdate (StockPriceUpdate stockPriceUpdate ) { 
		String key = getKey( stockPriceUpdate.getId() ) ;
		cache.remove(key);
	}

}
