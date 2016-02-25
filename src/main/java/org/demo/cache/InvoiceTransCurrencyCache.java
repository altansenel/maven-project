/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.InvoiceTransCurrency ;

/**
 * Very basic cache for InvoiceTransCurrency instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class InvoiceTransCurrencyCache
{
	private final static Map<String,InvoiceTransCurrency> cache = new Hashtable<String,InvoiceTransCurrency>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given InvoiceTransCurrency instance in the cache
	 * @param InvoiceTransCurrency instance to be stored
	 */
	public final static void putInvoiceTransCurrency(InvoiceTransCurrency invoiceTransCurrency ) {
		String key = getKey( invoiceTransCurrency.getId() ) ;
		cache.put(key, invoiceTransCurrency );
	}
	
	/**
	 * Get the InvoiceTransCurrency instance for the given primary key
     * @param id 
	 * @return the InvoiceTransCurrency instance (or null if none)
	 */
	public final static InvoiceTransCurrency getInvoiceTransCurrency( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the InvoiceTransCurrency associated with the given primary key
     * @param id 
	 */
	public final static void removeInvoiceTransCurrency ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given InvoiceTransCurrency from the cache using its primary key
	 * @param InvoiceTransCurrency instance to be removed
	 */
	public final static void removeInvoiceTransCurrency (InvoiceTransCurrency invoiceTransCurrency ) { 
		String key = getKey( invoiceTransCurrency.getId() ) ;
		cache.remove(key);
	}

}