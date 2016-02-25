/*
 * JUnit test case for bean ChqbllDetailHistory
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ChqbllDetailHistory ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ChqbllDetailHistory
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllDetailHistoryTest 
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
		
		System.out.println("Checking class ChqbllDetailHistory getters and setters ..." );
		
		ChqbllDetailHistory chqbllDetailHistory = new ChqbllDetailHistory();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		chqbllDetailHistory.setId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailHistory.getId() ) ;

		//--- Test setter/getter for field "sort"  ( type : String )
		// System.out.println(" checking field sort ..." );
		chqbllDetailHistory.setSort( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailHistory.getSort() ) ) ;

		//--- Test setter/getter for field "stepDate"  ( type : Date )
		// System.out.println(" checking field stepDate ..." );
		chqbllDetailHistory.setStepDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllDetailHistory.getStepDate() ) );

		//--- Test setter/getter for field "step"  ( type : String )
		// System.out.println(" checking field step ..." );
		chqbllDetailHistory.setStep( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailHistory.getStep() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		chqbllDetailHistory.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailHistory.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		chqbllDetailHistory.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllDetailHistory.getInsertAt() ) );

		//--- Test setter/getter for field "detailId"  ( type : Integer )
		// System.out.println(" checking field detailId ..." );
		chqbllDetailHistory.setDetailId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailHistory.getDetailId() ) ;

		//--- Test setter/getter for field "contactId"  ( type : Integer )
		// System.out.println(" checking field contactId ..." );
		chqbllDetailHistory.setContactId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailHistory.getContactId() ) ;

		//--- Test setter/getter for field "bankId"  ( type : Integer )
		// System.out.println(" checking field bankId ..." );
		chqbllDetailHistory.setBankId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailHistory.getBankId() ) ;

		//--- Test setter/getter for field "safeId"  ( type : Integer )
		// System.out.println(" checking field safeId ..." );
		chqbllDetailHistory.setSafeId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailHistory.getSafeId() ) ;

		
	}



}