/*
 * JUnit test case for AdminDocumentTarget caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.AdminDocumentTarget ;
import org.demo.cache.AdminDocumentTargetCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for AdminDocumentTarget caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminDocumentTargetCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(AdminDocumentTarget adminDocumentTarget) {
		adminDocumentTarget.setId( 1 ) ;
		adminDocumentTarget.setName( "A" ) ;
		adminDocumentTarget.setIsLocal( false ) ;
		adminDocumentTarget.setTargetType( "A" ) ;
		adminDocumentTarget.setViewType( "A" ) ;
		adminDocumentTarget.setPath( "A" ) ;
		adminDocumentTarget.setIsCompressed( false ) ;
		adminDocumentTarget.setDescription( "A" ) ;
		adminDocumentTarget.setIsActive( false ) ;
		adminDocumentTarget.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class AdminDocumentTargetCache ..." );
		
		AdminDocumentTarget adminDocumentTarget = new AdminDocumentTarget();
		populate(adminDocumentTarget);
		System.out.println("Entity populated : " + adminDocumentTarget );
		
		AdminDocumentTargetCache.putAdminDocumentTarget(adminDocumentTarget) ;	// Store in cache	
		
		AdminDocumentTarget adminDocumentTarget2 = AdminDocumentTargetCache.getAdminDocumentTarget( adminDocumentTarget.getId() );
		Assert.assertTrue( adminDocumentTarget == adminDocumentTarget2 ) ; // Same instance
		
		AdminDocumentTargetCache.removeAdminDocumentTarget(  adminDocumentTarget.getId() ) ; // Remove from cache	
		
		AdminDocumentTarget adminDocumentTarget3 = AdminDocumentTargetCache.getAdminDocumentTarget( adminDocumentTarget.getId() );
		Assert.assertTrue( null == adminDocumentTarget3 ) ; // Not in cache
		
	}
}
