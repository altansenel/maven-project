/*
 * JUnit test case for bean ChqbllTransDetail
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ChqbllTransDetail ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ChqbllTransDetail
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllTransDetailTest 
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
		
		System.out.println("Checking class ChqbllTransDetail getters and setters ..." );
		
		ChqbllTransDetail chqbllTransDetail = new ChqbllTransDetail();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		chqbllTransDetail.setId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllTransDetail.getId() ) ;

		//--- Test setter/getter for field "transId"  ( type : Integer )
		// System.out.println(" checking field transId ..." );
		chqbllTransDetail.setTransId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllTransDetail.getTransId() ) ;

		//--- Test setter/getter for field "detailId"  ( type : Integer )
		// System.out.println(" checking field detailId ..." );
		chqbllTransDetail.setDetailId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllTransDetail.getDetailId() ) ;

		
	}



}
