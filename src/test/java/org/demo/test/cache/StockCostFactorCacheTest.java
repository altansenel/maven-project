/*
 * JUnit test case for StockCostFactor caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockCostFactor ;
import org.demo.cache.StockCostFactorCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockCostFactor caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCostFactorCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockCostFactor stockCostFactor) {
		stockCostFactor.setId( 1 ) ;
		stockCostFactor.setName( "A" ) ;
		stockCostFactor.setFactorType( "A" ) ;
		stockCostFactor.setCalcType( "A" ) ;
		stockCostFactor.setEffectType( "A" ) ;
		stockCostFactor.setEffect( 12.345 ) ;
		stockCostFactor.setInsertBy( "A" ) ;
		stockCostFactor.setInsertAt( now ) ;
		stockCostFactor.setUpdateBy( "A" ) ;
		stockCostFactor.setUpdateAt( now ) ;
		stockCostFactor.setIsActive( false ) ;
		stockCostFactor.setWorkspace( 1 ) ;
		stockCostFactor.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockCostFactorCache ..." );
		
		StockCostFactor stockCostFactor = new StockCostFactor();
		populate(stockCostFactor);
		System.out.println("Entity populated : " + stockCostFactor );
		
		StockCostFactorCache.putStockCostFactor(stockCostFactor) ;	// Store in cache	
		
		StockCostFactor stockCostFactor2 = StockCostFactorCache.getStockCostFactor( stockCostFactor.getId() );
		Assert.assertTrue( stockCostFactor == stockCostFactor2 ) ; // Same instance
		
		StockCostFactorCache.removeStockCostFactor(  stockCostFactor.getId() ) ; // Remove from cache	
		
		StockCostFactor stockCostFactor3 = StockCostFactorCache.getStockCostFactor( stockCostFactor.getId() );
		Assert.assertTrue( null == stockCostFactor3 ) ; // Not in cache
		
	}
}