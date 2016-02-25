/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.StockCostingInventory ;

/**
 * Very basic cache for StockCostingInventory instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCostingInventoryCache
{
	private final static Map<String,StockCostingInventory> cache = new Hashtable<String,StockCostingInventory>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given StockCostingInventory instance in the cache
	 * @param StockCostingInventory instance to be stored
	 */
	public final static void putStockCostingInventory(StockCostingInventory stockCostingInventory ) {
		String key = getKey( stockCostingInventory.getId() ) ;
		cache.put(key, stockCostingInventory );
	}
	
	/**
	 * Get the StockCostingInventory instance for the given primary key
     * @param id 
	 * @return the StockCostingInventory instance (or null if none)
	 */
	public final static StockCostingInventory getStockCostingInventory( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the StockCostingInventory associated with the given primary key
     * @param id 
	 */
	public final static void removeStockCostingInventory ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given StockCostingInventory from the cache using its primary key
	 * @param StockCostingInventory instance to be removed
	 */
	public final static void removeStockCostingInventory (StockCostingInventory stockCostingInventory ) { 
		String key = getKey( stockCostingInventory.getId() ) ;
		cache.remove(key);
	}

}
