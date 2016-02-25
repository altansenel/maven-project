/*
 * JUnit test case for ChqbllDetailHistory caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.ChqbllDetailHistory ;
import org.demo.cache.ChqbllDetailHistoryCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for ChqbllDetailHistory caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllDetailHistoryCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(ChqbllDetailHistory chqbllDetailHistory) {
		chqbllDetailHistory.setId( 1 ) ;
		chqbllDetailHistory.setSort( "A" ) ;
		chqbllDetailHistory.setStepDate( now ) ;
		chqbllDetailHistory.setStep( "A" ) ;
		chqbllDetailHistory.setInsertBy( "A" ) ;
		chqbllDetailHistory.setInsertAt( now ) ;
		chqbllDetailHistory.setDetailId( 1 ) ;
		chqbllDetailHistory.setContactId( 1 ) ;
		chqbllDetailHistory.setBankId( 1 ) ;
		chqbllDetailHistory.setSafeId( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class ChqbllDetailHistoryCache ..." );
		
		ChqbllDetailHistory chqbllDetailHistory = new ChqbllDetailHistory();
		populate(chqbllDetailHistory);
		System.out.println("Entity populated : " + chqbllDetailHistory );
		
		ChqbllDetailHistoryCache.putChqbllDetailHistory(chqbllDetailHistory) ;	// Store in cache	
		
		ChqbllDetailHistory chqbllDetailHistory2 = ChqbllDetailHistoryCache.getChqbllDetailHistory( chqbllDetailHistory.getId() );
		Assert.assertTrue( chqbllDetailHistory == chqbllDetailHistory2 ) ; // Same instance
		
		ChqbllDetailHistoryCache.removeChqbllDetailHistory(  chqbllDetailHistory.getId() ) ; // Remove from cache	
		
		ChqbllDetailHistory chqbllDetailHistory3 = ChqbllDetailHistoryCache.getChqbllDetailHistory( chqbllDetailHistory.getId() );
		Assert.assertTrue( null == chqbllDetailHistory3 ) ; // Not in cache
		
	}
}