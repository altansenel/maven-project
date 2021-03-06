/*
 * JUnit test case for AdminExtraFields caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.AdminExtraFields ;
import org.demo.cache.AdminExtraFieldsCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for AdminExtraFields caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminExtraFieldsCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(AdminExtraFields adminExtraFields) {
		adminExtraFields.setId( 1 ) ;
		adminExtraFields.setIdno( 1 ) ;
		adminExtraFields.setDistinction( "A" ) ;
		adminExtraFields.setName( "A" ) ;
		adminExtraFields.setIsRequired( false ) ;
		adminExtraFields.setIsActive( false ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class AdminExtraFieldsCache ..." );
		
		AdminExtraFields adminExtraFields = new AdminExtraFields();
		populate(adminExtraFields);
		System.out.println("Entity populated : " + adminExtraFields );
		
		AdminExtraFieldsCache.putAdminExtraFields(adminExtraFields) ;	// Store in cache	
		
		AdminExtraFields adminExtraFields2 = AdminExtraFieldsCache.getAdminExtraFields( adminExtraFields.getId() );
		Assert.assertTrue( adminExtraFields == adminExtraFields2 ) ; // Same instance
		
		AdminExtraFieldsCache.removeAdminExtraFields(  adminExtraFields.getId() ) ; // Remove from cache	
		
		AdminExtraFields adminExtraFields3 = AdminExtraFieldsCache.getAdminExtraFields( adminExtraFields.getId() );
		Assert.assertTrue( null == adminExtraFields3 ) ; // Not in cache
		
	}
}
