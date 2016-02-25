/*
 * JUnit test case for StockTransDetail caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.StockTransDetail ;
import org.demo.cache.StockTransDetailCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for StockTransDetail caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockTransDetailCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(StockTransDetail stockTransDetail) {
		stockTransDetail.setId( 1 ) ;
		stockTransDetail.setReceiptNo( 1 ) ;
		stockTransDetail.setRight( "A" ) ;
		stockTransDetail.setTransDate( now ) ;
		stockTransDetail.setDeliveryDate( now ) ;
		stockTransDetail.setTransType( "A" ) ;
		stockTransDetail.setRowNo( 1 ) ;
		stockTransDetail.setStockId( 1 ) ;
		stockTransDetail.setName( "A" ) ;
		stockTransDetail.setQuantity( 12.345 ) ;
		stockTransDetail.setUnit( "A" ) ;
		stockTransDetail.setUnitRatio( 12.345 ) ;
		stockTransDetail.setBasePrice( 12.345 ) ;
		stockTransDetail.setPrice( 12.345 ) ;
		stockTransDetail.setTaxRate( 12.345 ) ;
		stockTransDetail.setTaxRate2( 12.345 ) ;
		stockTransDetail.setTaxRate3( 12.345 ) ;
		stockTransDetail.setDiscountRate1( 12.345 ) ;
		stockTransDetail.setDiscountRate2( 12.345 ) ;
		stockTransDetail.setDiscountRate3( 12.345 ) ;
		stockTransDetail.setAmount( 12.345 ) ;
		stockTransDetail.setTaxAmount( 12.345 ) ;
		stockTransDetail.setDiscountAmount( 12.345 ) ;
		stockTransDetail.setTotal( 12.345 ) ;
		stockTransDetail.setDescription( "A" ) ;
		stockTransDetail.setTransYear( 1 ) ;
		stockTransDetail.setTransMonth( "A" ) ;
		stockTransDetail.setUnit1( "A" ) ;
		stockTransDetail.setUnit2( "A" ) ;
		stockTransDetail.setUnit3( "A" ) ;
		stockTransDetail.setUnit2ratio( 12.345 ) ;
		stockTransDetail.setUnit3ratio( 12.345 ) ;
		stockTransDetail.setExcCode( "A" ) ;
		stockTransDetail.setExcRate( 12.345 ) ;
		stockTransDetail.setExcEquivalent( 12.345 ) ;
		stockTransDetail.setPlusFactorAmount( 12.345 ) ;
		stockTransDetail.setMinusFactorAmount( 12.345 ) ;
		stockTransDetail.setSerialNo( "A" ) ;
		stockTransDetail.setInput( 12.345 ) ;
		stockTransDetail.setOutput( 12.345 ) ;
		stockTransDetail.setInTotal( 12.345 ) ;
		stockTransDetail.setOutTotal( 12.345 ) ;
		stockTransDetail.setIsReturn( false ) ;
		stockTransDetail.setRetInput( 12.345 ) ;
		stockTransDetail.setRetOutput( 12.345 ) ;
		stockTransDetail.setRetInTotal( 12.345 ) ;
		stockTransDetail.setRetOutTotal( 12.345 ) ;
		stockTransDetail.setNetInput( 12.345 ) ;
		stockTransDetail.setNetOutput( 12.345 ) ;
		stockTransDetail.setNetInTotal( 12.345 ) ;
		stockTransDetail.setNetOutTotal( 12.345 ) ;
		stockTransDetail.setHasCostEffect( false ) ;
		stockTransDetail.setTransId( 1 ) ;
		stockTransDetail.setDepotId( 1 ) ;
		stockTransDetail.setContactId( 1 ) ;
		stockTransDetail.setSellerId( 1 ) ;
		stockTransDetail.setTransSourceId( 1 ) ;
		stockTransDetail.setTransPointId( 1 ) ;
		stockTransDetail.setPrivateCodeId( 1 ) ;
		stockTransDetail.setWorkspace( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class StockTransDetailCache ..." );
		
		StockTransDetail stockTransDetail = new StockTransDetail();
		populate(stockTransDetail);
		System.out.println("Entity populated : " + stockTransDetail );
		
		StockTransDetailCache.putStockTransDetail(stockTransDetail) ;	// Store in cache	
		
		StockTransDetail stockTransDetail2 = StockTransDetailCache.getStockTransDetail( stockTransDetail.getId() );
		Assert.assertTrue( stockTransDetail == stockTransDetail2 ) ; // Same instance
		
		StockTransDetailCache.removeStockTransDetail(  stockTransDetail.getId() ) ; // Remove from cache	
		
		StockTransDetail stockTransDetail3 = StockTransDetailCache.getStockTransDetail( stockTransDetail.getId() );
		Assert.assertTrue( null == stockTransDetail3 ) ; // Not in cache
		
	}
}
