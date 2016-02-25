/*
 * JUnit test case for Stock caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.Stock ;
import org.demo.cache.StockCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Stock caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(Stock stock) {
		stock.setId( 1 ) ;
		stock.setCode( "A" ) ;
		stock.setName( "A" ) ;
		stock.setExcCode( "A" ) ;
		stock.setProviderCode( "A" ) ;
		stock.setUnit1( "A" ) ;
		stock.setUnit2( "A" ) ;
		stock.setUnit3( "A" ) ;
		stock.setUnit2ratio( 12.345 ) ;
		stock.setUnit3ratio( 12.345 ) ;
		stock.setBuyPrice( 12.345 ) ;
		stock.setSellPrice( 12.345 ) ;
		stock.setBuyTax( 12.345 ) ;
		stock.setSellTax( 12.345 ) ;
		stock.setTaxRate2( 12.345 ) ;
		stock.setTaxRate3( 12.345 ) ;
		stock.setPrimRate( 12.345 ) ;
		stock.setMaxLimit( 12.345 ) ;
		stock.setMinLimit( 12.345 ) ;
		stock.setNote( "A" ) ;
		stock.setCategoryId( 1 ) ;
		stock.setExtraField0Id( 1 ) ;
		stock.setExtraField1Id( 1 ) ;
		stock.setExtraField2Id( 1 ) ;
		stock.setExtraField3Id( 1 ) ;
		stock.setExtraField4Id( 1 ) ;
		stock.setExtraField5Id( 1 ) ;
		stock.setExtraField6Id( 1 ) ;
		stock.setExtraField7Id( 1 ) ;
		stock.setExtraField8Id( 1 ) ;
		stock.setExtraField9Id( 1 ) ;
		stock.setInsertBy( "A" ) ;
		stock.setInsertAt( now ) ;
		stock.setUpdateBy( "A" ) ;
		stock.setUpdateAt( now ) ;
		stock.setIsActive( false ) ;
		stock.setWorkspace( 1 ) ;
		stock.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockCache ..." );
		
		Stock stock = new Stock();
		populate(stock);
		System.out.println("Entity populated : " + stock );
		
		StockCache.putStock(stock) ;	// Store in cache	
		
		Stock stock2 = StockCache.getStock( stock.getId() );
		Assert.assertTrue( stock == stock2 ) ; // Same instance
		
		StockCache.removeStock(  stock.getId() ) ; // Remove from cache	
		
		Stock stock3 = StockCache.getStock( stock.getId() );
		Assert.assertTrue( null == stock3 ) ; // Not in cache
		
	}
}