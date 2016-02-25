/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.InvoiceTransTax ;

/**
 * Very basic cache for InvoiceTransTax instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class InvoiceTransTaxCache
{
	private final static Map<String,InvoiceTransTax> cache = new Hashtable<String,InvoiceTransTax>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given InvoiceTransTax instance in the cache
	 * @param InvoiceTransTax instance to be stored
	 */
	public final static void putInvoiceTransTax(InvoiceTransTax invoiceTransTax ) {
		String key = getKey( invoiceTransTax.getId() ) ;
		cache.put(key, invoiceTransTax );
	}
	
	/**
	 * Get the InvoiceTransTax instance for the given primary key
     * @param id 
	 * @return the InvoiceTransTax instance (or null if none)
	 */
	public final static InvoiceTransTax getInvoiceTransTax( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the InvoiceTransTax associated with the given primary key
     * @param id 
	 */
	public final static void removeInvoiceTransTax ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given InvoiceTransTax from the cache using its primary key
	 * @param InvoiceTransTax instance to be removed
	 */
	public final static void removeInvoiceTransTax (InvoiceTransTax invoiceTransTax ) { 
		String key = getKey( invoiceTransTax.getId() ) ;
		cache.remove(key);
	}

}
