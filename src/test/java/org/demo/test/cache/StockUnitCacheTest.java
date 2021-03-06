/*
 * JUnit test case for StockUnit caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockUnit ;
import org.demo.cache.StockUnitCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockUnit caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockUnitCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockUnit stockUnit) {
		stockUnit.setId( 1 ) ;
		stockUnit.setName( "A" ) ;
		stockUnit.setInsertBy( "A" ) ;
		stockUnit.setInsertAt( now ) ;
		stockUnit.setUpdateBy( "A" ) ;
		stockUnit.setUpdateAt( now ) ;
		stockUnit.setIsActive( false ) ;
		stockUnit.setWorkspace( 1 ) ;
		stockUnit.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockUnitCache ..." );
		
		StockUnit stockUnit = new StockUnit();
		populate(stockUnit);
		System.out.println("Entity populated : " + stockUnit );
		
		StockUnitCache.putStockUnit(stockUnit) ;	// Store in cache	
		
		StockUnit stockUnit2 = StockUnitCache.getStockUnit( stockUnit.getId() );
		Assert.assertTrue( stockUnit == stockUnit2 ) ; // Same instance
		
		StockUnitCache.removeStockUnit(  stockUnit.getId() ) ; // Remove from cache	
		
		StockUnit stockUnit3 = StockUnitCache.getStockUnit( stockUnit.getId() );
		Assert.assertTrue( null == stockUnit3 ) ; // Not in cache
		
	}
}
