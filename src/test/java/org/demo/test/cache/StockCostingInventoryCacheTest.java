/*
 * JUnit test case for StockCostingInventory caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockCostingInventory ;
import org.demo.cache.StockCostingInventoryCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockCostingInventory caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCostingInventoryCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockCostingInventory stockCostingInventory) {
		stockCostingInventory.setId( 1 ) ;
		stockCostingInventory.setDate( now ) ;
		stockCostingInventory.setInput( 12.345 ) ;
		stockCostingInventory.setRemain( 12.345 ) ;
		stockCostingInventory.setPrice( 12.345 ) ;
		stockCostingInventory.setAmount( 12.345 ) ;
		stockCostingInventory.setCostingId( 1 ) ;
		stockCostingInventory.setStockId( 1 ) ;
		stockCostingInventory.setDepotId( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockCostingInventoryCache ..." );
		
		StockCostingInventory stockCostingInventory = new StockCostingInventory();
		populate(stockCostingInventory);
		System.out.println("Entity populated : " + stockCostingInventory );
		
		StockCostingInventoryCache.putStockCostingInventory(stockCostingInventory) ;	// Store in cache	
		
		StockCostingInventory stockCostingInventory2 = StockCostingInventoryCache.getStockCostingInventory( stockCostingInventory.getId() );
		Assert.assertTrue( stockCostingInventory == stockCostingInventory2 ) ; // Same instance
		
		StockCostingInventoryCache.removeStockCostingInventory(  stockCostingInventory.getId() ) ; // Remove from cache	
		
		StockCostingInventory stockCostingInventory3 = StockCostingInventoryCache.getStockCostingInventory( stockCostingInventory.getId() );
		Assert.assertTrue( null == stockCostingInventory3 ) ; // Not in cache
		
	}
}
