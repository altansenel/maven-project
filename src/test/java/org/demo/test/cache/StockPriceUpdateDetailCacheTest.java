/*
 * JUnit test case for StockPriceUpdateDetail caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockPriceUpdateDetail ;
import org.demo.cache.StockPriceUpdateDetailCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockPriceUpdateDetail caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockPriceUpdateDetailCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockPriceUpdateDetail stockPriceUpdateDetail) {
		stockPriceUpdateDetail.setId( 1 ) ;
		stockPriceUpdateDetail.setPriceUpdateId( 1 ) ;
		stockPriceUpdateDetail.setStockId( 1 ) ;
		stockPriceUpdateDetail.setBuyPrice( 12.345 ) ;
		stockPriceUpdateDetail.setSellPrice( 12.345 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockPriceUpdateDetailCache ..." );
		
		StockPriceUpdateDetail stockPriceUpdateDetail = new StockPriceUpdateDetail();
		populate(stockPriceUpdateDetail);
		System.out.println("Entity populated : " + stockPriceUpdateDetail );
		
		StockPriceUpdateDetailCache.putStockPriceUpdateDetail(stockPriceUpdateDetail) ;	// Store in cache	
		
		StockPriceUpdateDetail stockPriceUpdateDetail2 = StockPriceUpdateDetailCache.getStockPriceUpdateDetail( stockPriceUpdateDetail.getId() );
		Assert.assertTrue( stockPriceUpdateDetail == stockPriceUpdateDetail2 ) ; // Same instance
		
		StockPriceUpdateDetailCache.removeStockPriceUpdateDetail(  stockPriceUpdateDetail.getId() ) ; // Remove from cache	
		
		StockPriceUpdateDetail stockPriceUpdateDetail3 = StockPriceUpdateDetailCache.getStockPriceUpdateDetail( stockPriceUpdateDetail.getId() );
		Assert.assertTrue( null == stockPriceUpdateDetail3 ) ; // Not in cache
		
	}
}