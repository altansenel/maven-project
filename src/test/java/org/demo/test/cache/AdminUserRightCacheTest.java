/*
 * JUnit test case for AdminUserRight caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.AdminUserRight ;
import org.demo.cache.AdminUserRightCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for AdminUserRight caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminUserRightCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(AdminUserRight adminUserRight) {
		adminUserRight.setId( 1 ) ;
		adminUserRight.setName( "A" ) ;
		adminUserRight.setRightLevel( "A" ) ;
		adminUserRight.setIsCrud( false ) ;
		adminUserRight.setUserRoleId( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class AdminUserRightCache ..." );
		
		AdminUserRight adminUserRight = new AdminUserRight();
		populate(adminUserRight);
		System.out.println("Entity populated : " + adminUserRight );
		
		AdminUserRightCache.putAdminUserRight(adminUserRight) ;	// Store in cache	
		
		AdminUserRight adminUserRight2 = AdminUserRightCache.getAdminUserRight( adminUserRight.getId() );
		Assert.assertTrue( adminUserRight == adminUserRight2 ) ; // Same instance
		
		AdminUserRightCache.removeAdminUserRight(  adminUserRight.getId() ) ; // Remove from cache	
		
		AdminUserRight adminUserRight3 = AdminUserRightCache.getAdminUserRight( adminUserRight.getId() );
		Assert.assertTrue( null == adminUserRight3 ) ; // Not in cache
		
	}
}
