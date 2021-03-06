/*
 * JUnit test case for StockPriceUpdate caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockPriceUpdate ;
import org.demo.cache.StockPriceUpdateCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockPriceUpdate caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockPriceUpdateCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockPriceUpdate stockPriceUpdate) {
		stockPriceUpdate.setId( 1 ) ;
		stockPriceUpdate.setName( "A" ) ;
		stockPriceUpdate.setExecDate( now ) ;
		stockPriceUpdate.setEffectType( "A" ) ;
		stockPriceUpdate.setEffectDirection( "A" ) ;
		stockPriceUpdate.setEffect( 12.345 ) ;
		stockPriceUpdate.setDescription( "A" ) ;
		stockPriceUpdate.setBuyPrice( false ) ;
		stockPriceUpdate.setSellPrice( false ) ;
		stockPriceUpdate.setProviderCode( "A" ) ;
		stockPriceUpdate.setInsertBy( "A" ) ;
		stockPriceUpdate.setInsertAt( now ) ;
		stockPriceUpdate.setUpdateBy( "A" ) ;
		stockPriceUpdate.setUpdateAt( now ) ;
		stockPriceUpdate.setCategoryId( 1 ) ;
		stockPriceUpdate.setExtraField0Id( 1 ) ;
		stockPriceUpdate.setExtraField1Id( 1 ) ;
		stockPriceUpdate.setExtraField2Id( 1 ) ;
		stockPriceUpdate.setExtraField3Id( 1 ) ;
		stockPriceUpdate.setExtraField4Id( 1 ) ;
		stockPriceUpdate.setExtraField5Id( 1 ) ;
		stockPriceUpdate.setExtraField6Id( 1 ) ;
		stockPriceUpdate.setExtraField7Id( 1 ) ;
		stockPriceUpdate.setExtraField8Id( 1 ) ;
		stockPriceUpdate.setExtraField9Id( 1 ) ;
		stockPriceUpdate.setWorkspace( 1 ) ;
		stockPriceUpdate.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockPriceUpdateCache ..." );
		
		StockPriceUpdate stockPriceUpdate = new StockPriceUpdate();
		populate(stockPriceUpdate);
		System.out.println("Entity populated : " + stockPriceUpdate );
		
		StockPriceUpdateCache.putStockPriceUpdate(stockPriceUpdate) ;	// Store in cache	
		
		StockPriceUpdate stockPriceUpdate2 = StockPriceUpdateCache.getStockPriceUpdate( stockPriceUpdate.getId() );
		Assert.assertTrue( stockPriceUpdate == stockPriceUpdate2 ) ; // Same instance
		
		StockPriceUpdateCache.removeStockPriceUpdate(  stockPriceUpdate.getId() ) ; // Remove from cache	
		
		StockPriceUpdate stockPriceUpdate3 = StockPriceUpdateCache.getStockPriceUpdate( stockPriceUpdate.getId() );
		Assert.assertTrue( null == stockPriceUpdate3 ) ; // Not in cache
		
	}
}
