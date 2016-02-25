/*
 * JUnit test case for bean WaybillTransRelation
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.WaybillTransRelation ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean WaybillTransRelation
 * 
 * @author Telosys Tools Generator
 *
 */
public class WaybillTransRelationTest 
{
	protected static final byte    byteValue    = 1 ;
	protected static final short   shortValue   = 1 ;
	protected static final int     intValue     = 1 ;
	protected static final int     integerValue = 1 ;
	protected static final long    longValue    = 1 ;
	
	protected static final float   floatValue    = 1.234f ;
	protected static final double  doubleValue   = 1.234 ;
	
	protected static final BigDecimal bigdecimalValue = new BigDecimal("12.3456");
	
	protected static final String  stringValue  = "A" ;
	
	protected static final java.util.Date     dateValue         = new java.util.Date();
	protected static final java.sql.Date      sqldateValue      = new java.sql.Date(dateValue.getTime());
	protected static final java.sql.Time      sqltimeValue      = new java.sql.Time(dateValue.getTime());
	protected static final java.sql.Timestamp sqltimestampValue = new java.sql.Timestamp(dateValue.getTime());

	protected static final byte[]  bytesArray  = "ABCD".getBytes() ;

	@Test
	public void testSettersAndGetters() {
		
		System.out.println("Checking class WaybillTransRelation getters and setters ..." );
		
		WaybillTransRelation waybillTransRelation = new WaybillTransRelation();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		waybillTransRelation.setId( integerValue ) ;
		Assert.assertTrue( integerValue == waybillTransRelation.getId() ) ;

		//--- Test setter/getter for field "relId"  ( type : Integer )
		// System.out.println(" checking field relId ..." );
		waybillTransRelation.setRelId( integerValue ) ;
		Assert.assertTrue( integerValue == waybillTransRelation.getRelId() ) ;

		//--- Test setter/getter for field "relRight"  ( type : String )
		// System.out.println(" checking field relRight ..." );
		waybillTransRelation.setRelRight( stringValue ) ;
		Assert.assertTrue( stringValue.equals( waybillTransRelation.getRelRight() ) ) ;

		//--- Test setter/getter for field "relReceiptNo"  ( type : Integer )
		// System.out.println(" checking field relReceiptNo ..." );
		waybillTransRelation.setRelReceiptNo( integerValue ) ;
		Assert.assertTrue( integerValue == waybillTransRelation.getRelReceiptNo() ) ;

		//--- Test setter/getter for field "transId"  ( type : Integer )
		// System.out.println(" checking field transId ..." );
		waybillTransRelation.setTransId( integerValue ) ;
		Assert.assertTrue( integerValue == waybillTransRelation.getTransId() ) ;

		
	}



}