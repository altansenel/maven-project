/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.BankTransSource ;

/**
 * Very basic cache for BankTransSource instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class BankTransSourceCache
{
	private final static Map<String,BankTransSource> cache = new Hashtable<String,BankTransSource>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given BankTransSource instance in the cache
	 * @param BankTransSource instance to be stored
	 */
	public final static void putBankTransSource(BankTransSource bankTransSource ) {
		String key = getKey( bankTransSource.getId() ) ;
		cache.put(key, bankTransSource );
	}
	
	/**
	 * Get the BankTransSource instance for the given primary key
     * @param id 
	 * @return the BankTransSource instance (or null if none)
	 */
	public final static BankTransSource getBankTransSource( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the BankTransSource associated with the given primary key
     * @param id 
	 */
	public final static void removeBankTransSource ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given BankTransSource from the cache using its primary key
	 * @param BankTransSource instance to be removed
	 */
	public final static void removeBankTransSource (BankTransSource bankTransSource ) { 
		String key = getKey( bankTransSource.getId() ) ;
		cache.remove(key);
	}

}
