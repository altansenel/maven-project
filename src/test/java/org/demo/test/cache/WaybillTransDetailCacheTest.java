/*
 * JUnit test case for WaybillTransDetail caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.WaybillTransDetail ;
import org.demo.cache.WaybillTransDetailCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for WaybillTransDetail caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class WaybillTransDetailCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(WaybillTransDetail waybillTransDetail) {
		waybillTransDetail.setId( 1 ) ;
		waybillTransDetail.setReceiptNo( 1 ) ;
		waybillTransDetail.setRight( "A" ) ;
		waybillTransDetail.setTransDate( now ) ;
		waybillTransDetail.setDeliveryDate( now ) ;
		waybillTransDetail.setTransType( "A" ) ;
		waybillTransDetail.setRowNo( 1 ) ;
		waybillTransDetail.setStockId( 1 ) ;
		waybillTransDetail.setName( "A" ) ;
		waybillTransDetail.setQuantity( 12.345 ) ;
		waybillTransDetail.setUnit( "A" ) ;
		waybillTransDetail.setUnitRatio( 12.345 ) ;
		waybillTransDetail.setBasePrice( 12.345 ) ;
		waybillTransDetail.setPrice( 12.345 ) ;
		waybillTransDetail.setTaxRate( 12.345 ) ;
		waybillTransDetail.setDiscountRate1( 12.345 ) ;
		waybillTransDetail.setDiscountRate2( 12.345 ) ;
		waybillTransDetail.setDiscountRate3( 12.345 ) ;
		waybillTransDetail.setAmount( 12.345 ) ;
		waybillTransDetail.setTaxAmount( 12.345 ) ;
		waybillTransDetail.setDiscountAmount( 12.345 ) ;
		waybillTransDetail.setTotal( 12.345 ) ;
		waybillTransDetail.setDescription( "A" ) ;
		waybillTransDetail.setTransYear( 1 ) ;
		waybillTransDetail.setTransMonth( "A" ) ;
		waybillTransDetail.setUnit1( "A" ) ;
		waybillTransDetail.setUnit2( "A" ) ;
		waybillTransDetail.setUnit3( "A" ) ;
		waybillTransDetail.setUnit2ratio( 12.345 ) ;
		waybillTransDetail.setUnit3ratio( 12.345 ) ;
		waybillTransDetail.setExcCode( "A" ) ;
		waybillTransDetail.setExcRate( 12.345 ) ;
		waybillTransDetail.setExcEquivalent( 12.345 ) ;
		waybillTransDetail.setPlusFactorAmount( 12.345 ) ;
		waybillTransDetail.setMinusFactorAmount( 12.345 ) ;
		waybillTransDetail.setInput( 12.345 ) ;
		waybillTransDetail.setOutput( 12.345 ) ;
		waybillTransDetail.setInTotal( 12.345 ) ;
		waybillTransDetail.setOutTotal( 12.345 ) ;
		waybillTransDetail.setNetInput( 12.345 ) ;
		waybillTransDetail.setNetOutput( 12.345 ) ;
		waybillTransDetail.setNetInTotal( 12.345 ) ;
		waybillTransDetail.setNetOutTotal( 12.345 ) ;
		waybillTransDetail.setCompleted( 12.345 ) ;
		waybillTransDetail.setCancelled( 12.345 ) ;
		waybillTransDetail.setIsTransfer( false ) ;
		waybillTransDetail.setTransId( 1 ) ;
		waybillTransDetail.setDepotId( 1 ) ;
		waybillTransDetail.setContactId( 1 ) ;
		waybillTransDetail.setSellerId( 1 ) ;
		waybillTransDetail.setTransSourceId( 1 ) ;
		waybillTransDetail.setTransPointId( 1 ) ;
		waybillTransDetail.setPrivateCodeId( 1 ) ;
		waybillTransDetail.setStatusId( 1 ) ;
		waybillTransDetail.setWorkspace( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class WaybillTransDetailCache ..." );
		
		WaybillTransDetail waybillTransDetail = new WaybillTransDetail();
		populate(waybillTransDetail);
		System.out.println("Entity populated : " + waybillTransDetail );
		
		WaybillTransDetailCache.putWaybillTransDetail(waybillTransDetail) ;	// Store in cache	
		
		WaybillTransDetail waybillTransDetail2 = WaybillTransDetailCache.getWaybillTransDetail( waybillTransDetail.getId() );
		Assert.assertTrue( waybillTransDetail == waybillTransDetail2 ) ; // Same instance
		
		WaybillTransDetailCache.removeWaybillTransDetail(  waybillTransDetail.getId() ) ; // Remove from cache	
		
		WaybillTransDetail waybillTransDetail3 = WaybillTransDetailCache.getWaybillTransDetail( waybillTransDetail.getId() );
		Assert.assertTrue( null == waybillTransDetail3 ) ; // Not in cache
		
	}
}