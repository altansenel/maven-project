/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.TempContactAging ;

/**
 * Very basic cache for TempContactAging instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class TempContactAgingCache
{
	private final static Map<String,TempContactAging> cache = new Hashtable<String,TempContactAging>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
	 * @return the key
	 */
	private final static String getKey(  ) {
		return ""  ;
	}

	/**
	 * Put the given TempContactAging instance in the cache
	 * @param TempContactAging instance to be stored
	 */
	public final static void putTempContactAging(TempContactAging tempContactAging ) {
		String key = getKey(  ) ;
		cache.put(key, tempContactAging );
	}
	
	/**
	 * Get the TempContactAging instance for the given primary key
	 * @return the TempContactAging instance (or null if none)
	 */
	public final static TempContactAging getTempContactAging(  ) {
		String key = getKey(  ) ;
		return cache.get(key);
	}

	/**
	 * Removes the TempContactAging associated with the given primary key
	 */
	public final static void removeTempContactAging (  ) {
		String key = getKey(  ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given TempContactAging from the cache using its primary key
	 * @param TempContactAging instance to be removed
	 */
	public final static void removeTempContactAging (TempContactAging tempContactAging ) { 
		String key = getKey(  ) ;
		cache.remove(key);
	}

}
