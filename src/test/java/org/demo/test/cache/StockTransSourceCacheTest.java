/*
 * JUnit test case for StockTransSource caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockTransSource ;
import org.demo.cache.StockTransSourceCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockTransSource caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockTransSourceCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockTransSource stockTransSource) {
		stockTransSource.setId( 1 ) ;
		stockTransSource.setName( "A" ) ;
		stockTransSource.setSuitableRight( "A" ) ;
		stockTransSource.setHasCostEffect( false ) ;
		stockTransSource.setInsertBy( "A" ) ;
		stockTransSource.setInsertAt( now ) ;
		stockTransSource.setUpdateBy( "A" ) ;
		stockTransSource.setUpdateAt( now ) ;
		stockTransSource.setIsActive( false ) ;
		stockTransSource.setWorkspace( 1 ) ;
		stockTransSource.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockTransSourceCache ..." );
		
		StockTransSource stockTransSource = new StockTransSource();
		populate(stockTransSource);
		System.out.println("Entity populated : " + stockTransSource );
		
		StockTransSourceCache.putStockTransSource(stockTransSource) ;	// Store in cache	
		
		StockTransSource stockTransSource2 = StockTransSourceCache.getStockTransSource( stockTransSource.getId() );
		Assert.assertTrue( stockTransSource == stockTransSource2 ) ; // Same instance
		
		StockTransSourceCache.removeStockTransSource(  stockTransSource.getId() ) ; // Remove from cache	
		
		StockTransSource stockTransSource3 = StockTransSourceCache.getStockTransSource( stockTransSource.getId() );
		Assert.assertTrue( null == stockTransSource3 ) ; // Not in cache
		
	}
}
