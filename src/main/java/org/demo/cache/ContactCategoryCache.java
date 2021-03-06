/*
 * Very basic JavaBean cache
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.cache;

import java.util.Hashtable;
import java.util.Map;

import org.demo.bean.ContactCategory ;

/**
 * Very basic cache for ContactCategory instances (just for the Telosys Tools demo)
 * 
 * @author Telosys Tools Generator
 *
 */
public class ContactCategoryCache
{
	private final static Map<String,ContactCategory> cache = new Hashtable<String,ContactCategory>() ;
	
	/**
	 * Build the cache key from the Primary Key field(s)
     * @param id 
	 * @return the key
	 */
	private final static String getKey( Integer id ) {
		return ""  + id  ;
	}

	/**
	 * Put the given ContactCategory instance in the cache
	 * @param ContactCategory instance to be stored
	 */
	public final static void putContactCategory(ContactCategory contactCategory ) {
		String key = getKey( contactCategory.getId() ) ;
		cache.put(key, contactCategory );
	}
	
	/**
	 * Get the ContactCategory instance for the given primary key
     * @param id 
	 * @return the ContactCategory instance (or null if none)
	 */
	public final static ContactCategory getContactCategory( Integer id ) {
		String key = getKey( id ) ;
		return cache.get(key);
	}

	/**
	 * Removes the ContactCategory associated with the given primary key
     * @param id 
	 */
	public final static void removeContactCategory ( Integer id ) {
		String key = getKey( id ) ;
		cache.remove(key);
	}
	
	/**
	 * Removes the given ContactCategory from the cache using its primary key
	 * @param ContactCategory instance to be removed
	 */
	public final static void removeContactCategory (ContactCategory contactCategory ) { 
		String key = getKey( contactCategory.getId() ) ;
		cache.remove(key);
	}

}
