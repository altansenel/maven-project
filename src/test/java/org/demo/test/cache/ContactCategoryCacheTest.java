/*
 * JUnit test case for ContactCategory caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.ContactCategory ;
import org.demo.cache.ContactCategoryCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for ContactCategory caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ContactCategoryCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(ContactCategory contactCategory) {
		contactCategory.setId( 1 ) ;
		contactCategory.setName( "A" ) ;
		contactCategory.setWorkingDir( "A" ) ;
		contactCategory.setDebtLimit( 12.345 ) ;
		contactCategory.setCreditLimit( 12.345 ) ;
		contactCategory.setInsertBy( "A" ) ;
		contactCategory.setInsertAt( now ) ;
		contactCategory.setUpdateBy( "A" ) ;
		contactCategory.setUpdateAt( now ) ;
		contactCategory.setIsActive( false ) ;
		contactCategory.setWorkspace( 1 ) ;
		contactCategory.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class ContactCategoryCache ..." );
		
		ContactCategory contactCategory = new ContactCategory();
		populate(contactCategory);
		System.out.println("Entity populated : " + contactCategory );
		
		ContactCategoryCache.putContactCategory(contactCategory) ;	// Store in cache	
		
		ContactCategory contactCategory2 = ContactCategoryCache.getContactCategory( contactCategory.getId() );
		Assert.assertTrue( contactCategory == contactCategory2 ) ; // Same instance
		
		ContactCategoryCache.removeContactCategory(  contactCategory.getId() ) ; // Remove from cache	
		
		ContactCategory contactCategory3 = ContactCategoryCache.getContactCategory( contactCategory.getId() );
		Assert.assertTrue( null == contactCategory3 ) ; // Not in cache
		
	}
}
