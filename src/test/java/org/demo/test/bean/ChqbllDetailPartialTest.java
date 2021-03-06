/*
 * JUnit test case for bean ChqbllDetailPartial
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ChqbllDetailPartial ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ChqbllDetailPartial
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllDetailPartialTest 
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
		
		System.out.println("Checking class ChqbllDetailPartial getters and setters ..." );
		
		ChqbllDetailPartial chqbllDetailPartial = new ChqbllDetailPartial();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		chqbllDetailPartial.setId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailPartial.getId() ) ;

		//--- Test setter/getter for field "sort"  ( type : String )
		// System.out.println(" checking field sort ..." );
		chqbllDetailPartial.setSort( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailPartial.getSort() ) ) ;

		//--- Test setter/getter for field "isCustomer"  ( type : Boolean )
		// System.out.println(" checking field isCustomer ..." );
		chqbllDetailPartial.setIsCustomer( true ) ;
		Assert.assertTrue( chqbllDetailPartial.getIsCustomer() ) ;
		chqbllDetailPartial.setIsCustomer( false ) ;
		Assert.assertFalse( chqbllDetailPartial.getIsCustomer() ) ;

		//--- Test setter/getter for field "transDate"  ( type : Date )
		// System.out.println(" checking field transDate ..." );
		chqbllDetailPartial.setTransDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllDetailPartial.getTransDate() ) );

		//--- Test setter/getter for field "amount"  ( type : Double )
		// System.out.println(" checking field amount ..." );
		chqbllDetailPartial.setAmount( doubleValue ) ;
		Assert.assertTrue( doubleValue == chqbllDetailPartial.getAmount() ) ;

		//--- Test setter/getter for field "excCode"  ( type : String )
		// System.out.println(" checking field excCode ..." );
		chqbllDetailPartial.setExcCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailPartial.getExcCode() ) ) ;

		//--- Test setter/getter for field "excRate"  ( type : Double )
		// System.out.println(" checking field excRate ..." );
		chqbllDetailPartial.setExcRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == chqbllDetailPartial.getExcRate() ) ;

		//--- Test setter/getter for field "excEquivalent"  ( type : Double )
		// System.out.println(" checking field excEquivalent ..." );
		chqbllDetailPartial.setExcEquivalent( doubleValue ) ;
		Assert.assertTrue( doubleValue == chqbllDetailPartial.getExcEquivalent() ) ;

		//--- Test setter/getter for field "description"  ( type : String )
		// System.out.println(" checking field description ..." );
		chqbllDetailPartial.setDescription( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailPartial.getDescription() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		chqbllDetailPartial.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllDetailPartial.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		chqbllDetailPartial.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllDetailPartial.getInsertAt() ) );

		//--- Test setter/getter for field "detailId"  ( type : Integer )
		// System.out.println(" checking field detailId ..." );
		chqbllDetailPartial.setDetailId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailPartial.getDetailId() ) ;

		//--- Test setter/getter for field "safeId"  ( type : Integer )
		// System.out.println(" checking field safeId ..." );
		chqbllDetailPartial.setSafeId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailPartial.getSafeId() ) ;

		//--- Test setter/getter for field "transId"  ( type : Integer )
		// System.out.println(" checking field transId ..." );
		chqbllDetailPartial.setTransId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllDetailPartial.getTransId() ) ;

		
	}



}
