/*
 * JUnit test case for ChqbllPayrollDetail caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.ChqbllPayrollDetail ;
import org.demo.cache.ChqbllPayrollDetailCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for ChqbllPayrollDetail caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllPayrollDetailCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(ChqbllPayrollDetail chqbllPayrollDetail) {
		chqbllPayrollDetail.setId( 1 ) ;
		chqbllPayrollDetail.setSort( "A" ) ;
		chqbllPayrollDetail.setIsCustomer( false ) ;
		chqbllPayrollDetail.setPortfolioNo( 1 ) ;
		chqbllPayrollDetail.setRowNo( 1 ) ;
		chqbllPayrollDetail.setSerialNo( "A" ) ;
		chqbllPayrollDetail.setDueDate( now ) ;
		chqbllPayrollDetail.setAmount( 12.345 ) ;
		chqbllPayrollDetail.setDescription( "A" ) ;
		chqbllPayrollDetail.setDueYear( 1 ) ;
		chqbllPayrollDetail.setDueMonth( "A" ) ;
		chqbllPayrollDetail.setOwner( "A" ) ;
		chqbllPayrollDetail.setPaymentPlace( "A" ) ;
		chqbllPayrollDetail.setBankAccountNo( "A" ) ;
		chqbllPayrollDetail.setBankName( "A" ) ;
		chqbllPayrollDetail.setBankBranch( "A" ) ;
		chqbllPayrollDetail.setCorrespondentBranch( "A" ) ;
		chqbllPayrollDetail.setContactName( "A" ) ;
		chqbllPayrollDetail.setLastStep( "A" ) ;
		chqbllPayrollDetail.setLastContactName( "A" ) ;
		chqbllPayrollDetail.setSurety( "A" ) ;
		chqbllPayrollDetail.setSuretyAddress( "A" ) ;
		chqbllPayrollDetail.setSuretyPhone1( "A" ) ;
		chqbllPayrollDetail.setSuretyPhone2( "A" ) ;
		chqbllPayrollDetail.setExcCode( "A" ) ;
		chqbllPayrollDetail.setExcRate( 12.345 ) ;
		chqbllPayrollDetail.setExcEquivalent( 12.345 ) ;
		chqbllPayrollDetail.setTotalPaid( 12.345 ) ;
		chqbllPayrollDetail.setCbtypeId( 1 ) ;
		chqbllPayrollDetail.setTransId( 1 ) ;
		chqbllPayrollDetail.setTransSourceId( 1 ) ;
		chqbllPayrollDetail.setTransPointId( 1 ) ;
		chqbllPayrollDetail.setPrivateCodeId( 1 ) ;
		chqbllPayrollDetail.setContactId( 1 ) ;
		chqbllPayrollDetail.setBankId( 1 ) ;
		chqbllPayrollDetail.setWorkspace( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class ChqbllPayrollDetailCache ..." );
		
		ChqbllPayrollDetail chqbllPayrollDetail = new ChqbllPayrollDetail();
		populate(chqbllPayrollDetail);
		System.out.println("Entity populated : " + chqbllPayrollDetail );
		
		ChqbllPayrollDetailCache.putChqbllPayrollDetail(chqbllPayrollDetail) ;	// Store in cache	
		
		ChqbllPayrollDetail chqbllPayrollDetail2 = ChqbllPayrollDetailCache.getChqbllPayrollDetail( chqbllPayrollDetail.getId() );
		Assert.assertTrue( chqbllPayrollDetail == chqbllPayrollDetail2 ) ; // Same instance
		
		ChqbllPayrollDetailCache.removeChqbllPayrollDetail(  chqbllPayrollDetail.getId() ) ; // Remove from cache	
		
		ChqbllPayrollDetail chqbllPayrollDetail3 = ChqbllPayrollDetailCache.getChqbllPayrollDetail( chqbllPayrollDetail.getId() );
		Assert.assertTrue( null == chqbllPayrollDetail3 ) ; // Not in cache
		
	}
}