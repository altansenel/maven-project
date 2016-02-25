/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.OrderTransStatusHistory ;

/**
 * Very basic cache for OrderTransStatusHistory instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class OrderTransStatusHistoryCache
{
	private final static Map<String,OrderTransStatusHistory> cache = new Hashtable<String,OrderTransStatusHistory>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given OrderTransStatusHistory instance in the cache
	 * @param OrderTransStatusHistory instance to be stored
	 */
	public final static void putOrderTransStatusHistory(OrderTransStatusHistory orderTransStatusHistory ) {
		String key = getKey( orderTransStatusHistory.getId() ) ;
		cache.put(key, orderTransStatusHistory );
	}
	
	/**
	 * Get the OrderTransStatusHistory instance for the given primary key
     * @param id 
	 * @return the OrderTransStatusHistory instance (or null if none)
	 */
	public final static OrderTransStatusHistory getOrderTransStatusHistory( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the OrderTransStatusHistory associated with the given primary key
     * @param id 
	 */
	public final static void removeOrderTransStatusHistory ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given OrderTransStatusHistory from the cache using its primary key
	 * @param OrderTransStatusHistory instance to be removed
	 */
	public final static void removeOrderTransStatusHistory (OrderTransStatusHistory orderTransStatusHistory ) { 
		String key = getKey( orderTransStatusHistory.getId() ) ;
		cache.remove(key);
	}

}
