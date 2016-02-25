/*
 * JUnit test case for SaleCampaign caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.SaleCampaign ;
import org.demo.cache.SaleCampaignCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for SaleCampaign caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class SaleCampaignCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(SaleCampaign saleCampaign) {
		saleCampaign.setId( 1 ) ;
		saleCampaign.setName( "A" ) ;
		saleCampaign.setStartDate( now ) ;
		saleCampaign.setEndDate( now ) ;
		saleCampaign.setDiscountRate1( 12.345 ) ;
		saleCampaign.setDiscountRate2( 12.345 ) ;
		saleCampaign.setDiscountRate3( 12.345 ) ;
		saleCampaign.setPriority( (byte) 1 ) ;
		saleCampaign.setStockCategoryId( 1 ) ;
		saleCampaign.setExtraField0Id( 1 ) ;
		saleCampaign.setExtraField1Id( 1 ) ;
		saleCampaign.setExtraField2Id( 1 ) ;
		saleCampaign.setExtraField3Id( 1 ) ;
		saleCampaign.setExtraField4Id( 1 ) ;
		saleCampaign.setExtraField5Id( 1 ) ;
		saleCampaign.setExtraField6Id( 1 ) ;
		saleCampaign.setExtraField7Id( 1 ) ;
		saleCampaign.setExtraField8Id( 1 ) ;
		saleCampaign.setExtraField9Id( 1 ) ;
		saleCampaign.setInsertBy( "A" ) ;
		saleCampaign.setInsertAt( now ) ;
		saleCampaign.setUpdateBy( "A" ) ;
		saleCampaign.setUpdateAt( now ) ;
		saleCampaign.setIsActive( false ) ;
		saleCampaign.setWorkspace( 1 ) ;
		saleCampaign.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class SaleCampaignCache ..." );
		
		SaleCampaign saleCampaign = new SaleCampaign();
		populate(saleCampaign);
		System.out.println("Entity populated : " + saleCampaign );
		
		SaleCampaignCache.putSaleCampaign(saleCampaign) ;	// Store in cache	
		
		SaleCampaign saleCampaign2 = SaleCampaignCache.getSaleCampaign( saleCampaign.getId() );
		Assert.assertTrue( saleCampaign == saleCampaign2 ) ; // Same instance
		
		SaleCampaignCache.removeSaleCampaign(  saleCampaign.getId() ) ; // Remove from cache	
		
		SaleCampaign saleCampaign3 = SaleCampaignCache.getSaleCampaign( saleCampaign.getId() );
		Assert.assertTrue( null == saleCampaign3 ) ; // Not in cache
		
	}
}
