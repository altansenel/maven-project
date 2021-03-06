/*
 * JUnit test case for bean GlobalCurrencyRateDetail
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.GlobalCurrencyRateDetail ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean GlobalCurrencyRateDetail
 * 
 * @author Telosys Tools Generator
 *
 */
public class GlobalCurrencyRateDetailTest 
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
		
		System.out.println("Checking class GlobalCurrencyRateDetail getters and setters ..." );
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = new GlobalCurrencyRateDetail();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		globalCurrencyRateDetail.setId( integerValue ) ;
		Assert.assertTrue( integerValue == globalCurrencyRateDetail.getId() ) ;

		//--- Test setter/getter for field "date"  ( type : Date )
		// System.out.println(" checking field date ..." );
		globalCurrencyRateDetail.setDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( globalCurrencyRateDetail.getDate() ) );

		//--- Test setter/getter for field "code"  ( type : String )
		// System.out.println(" checking field code ..." );
		globalCurrencyRateDetail.setCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( globalCurrencyRateDetail.getCode() ) ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		globalCurrencyRateDetail.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( globalCurrencyRateDetail.getName() ) ) ;

		//--- Test setter/getter for field "buying"  ( type : Double )
		// System.out.println(" checking field buying ..." );
		globalCurrencyRateDetail.setBuying( doubleValue ) ;
		Assert.assertTrue( doubleValue == globalCurrencyRateDetail.getBuying() ) ;

		//--- Test setter/getter for field "selling"  ( type : Double )
		// System.out.println(" checking field selling ..." );
		globalCurrencyRateDetail.setSelling( doubleValue ) ;
		Assert.assertTrue( doubleValue == globalCurrencyRateDetail.getSelling() ) ;

		//--- Test setter/getter for field "currencyRateId"  ( type : Integer )
		// System.out.println(" checking field currencyRateId ..." );
		globalCurrencyRateDetail.setCurrencyRateId( integerValue ) ;
		Assert.assertTrue( integerValue == globalCurrencyRateDetail.getCurrencyRateId() ) ;

		
	}



}
