/*
 * JUnit test case for OrderTransDetail caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.OrderTransDetail ;
import org.demo.cache.OrderTransDetailCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for OrderTransDetail caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class OrderTransDetailCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(OrderTransDetail orderTransDetail) {
		orderTransDetail.setId( 1 ) ;
		orderTransDetail.setReceiptNo( 1 ) ;
		orderTransDetail.setRight( "A" ) ;
		orderTransDetail.setTransDate( now ) ;
		orderTransDetail.setDeliveryDate( now ) ;
		orderTransDetail.setTransType( "A" ) ;
		orderTransDetail.setRowNo( 1 ) ;
		orderTransDetail.setStockId( 1 ) ;
		orderTransDetail.setName( "A" ) ;
		orderTransDetail.setQuantity( 12.345 ) ;
		orderTransDetail.setUnit( "A" ) ;
		orderTransDetail.setUnitRatio( 12.345 ) ;
		orderTransDetail.setBasePrice( 12.345 ) ;
		orderTransDetail.setPrice( 12.345 ) ;
		orderTransDetail.setTaxRate( 12.345 ) ;
		orderTransDetail.setDiscountRate1( 12.345 ) ;
		orderTransDetail.setDiscountRate2( 12.345 ) ;
		orderTransDetail.setDiscountRate3( 12.345 ) ;
		orderTransDetail.setAmount( 12.345 ) ;
		orderTransDetail.setTaxAmount( 12.345 ) ;
		orderTransDetail.setDiscountAmount( 12.345 ) ;
		orderTransDetail.setTotal( 12.345 ) ;
		orderTransDetail.setDescription( "A" ) ;
		orderTransDetail.setTransYear( 1 ) ;
		orderTransDetail.setTransMonth( "A" ) ;
		orderTransDetail.setUnit1( "A" ) ;
		orderTransDetail.setUnit2( "A" ) ;
		orderTransDetail.setUnit3( "A" ) ;
		orderTransDetail.setUnit2ratio( 12.345 ) ;
		orderTransDetail.setUnit3ratio( 12.345 ) ;
		orderTransDetail.setExcCode( "A" ) ;
		orderTransDetail.setExcRate( 12.345 ) ;
		orderTransDetail.setExcEquivalent( 12.345 ) ;
		orderTransDetail.setPlusFactorAmount( 12.345 ) ;
		orderTransDetail.setMinusFactorAmount( 12.345 ) ;
		orderTransDetail.setInput( 12.345 ) ;
		orderTransDetail.setOutput( 12.345 ) ;
		orderTransDetail.setInTotal( 12.345 ) ;
		orderTransDetail.setOutTotal( 12.345 ) ;
		orderTransDetail.setNetInput( 12.345 ) ;
		orderTransDetail.setNetOutput( 12.345 ) ;
		orderTransDetail.setNetInTotal( 12.345 ) ;
		orderTransDetail.setNetOutTotal( 12.345 ) ;
		orderTransDetail.setCompleted( 12.345 ) ;
		orderTransDetail.setCancelled( 12.345 ) ;
		orderTransDetail.setIsTransfer( false ) ;
		orderTransDetail.setTransId( 1 ) ;
		orderTransDetail.setDepotId( 1 ) ;
		orderTransDetail.setContactId( 1 ) ;
		orderTransDetail.setSellerId( 1 ) ;
		orderTransDetail.setTransSourceId( 1 ) ;
		orderTransDetail.setTransPointId( 1 ) ;
		orderTransDetail.setPrivateCodeId( 1 ) ;
		orderTransDetail.setStatusId( 1 ) ;
		orderTransDetail.setWorkspace( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class OrderTransDetailCache ..." );
		
		OrderTransDetail orderTransDetail = new OrderTransDetail();
		populate(orderTransDetail);
		System.out.println("Entity populated : " + orderTransDetail );
		
		OrderTransDetailCache.putOrderTransDetail(orderTransDetail) ;	// Store in cache	
		
		OrderTransDetail orderTransDetail2 = OrderTransDetailCache.getOrderTransDetail( orderTransDetail.getId() );
		Assert.assertTrue( orderTransDetail == orderTransDetail2 ) ; // Same instance
		
		OrderTransDetailCache.removeOrderTransDetail(  orderTransDetail.getId() ) ; // Remove from cache	
		
		OrderTransDetail orderTransDetail3 = OrderTransDetailCache.getOrderTransDetail( orderTransDetail.getId() );
		Assert.assertTrue( null == orderTransDetail3 ) ; // Not in cache
		
	}
}
