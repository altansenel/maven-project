/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.StockCostingDetail ;

/**
 * Very basic cache for StockCostingDetail instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCostingDetailCache
{
	private final static Map<String,StockCostingDetail> cache = new Hashtable<String,StockCostingDetail>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given StockCostingDetail instance in the cache
	 * @param StockCostingDetail instance to be stored
	 */
	public final static void putStockCostingDetail(StockCostingDetail stockCostingDetail ) {
		String key = getKey( stockCostingDetail.getId() ) ;
		cache.put(key, stockCostingDetail );
	}
	
	/**
	 * Get the StockCostingDetail instance for the given primary key
     * @param id 
	 * @return the StockCostingDetail instance (or null if none)
	 */
	public final static StockCostingDetail getStockCostingDetail( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the StockCostingDetail associated with the given primary key
     * @param id 
	 */
	public final static void removeStockCostingDetail ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given StockCostingDetail from the cache using its primary key
	 * @param StockCostingDetail instance to be removed
	 */
	public final static void removeStockCostingDetail (StockCostingDetail stockCostingDetail ) { 
		String key = getKey( stockCostingDetail.getId() ) ;
		cache.remove(key);
	}

}