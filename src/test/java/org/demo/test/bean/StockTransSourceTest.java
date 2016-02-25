/*
 * JUnit test case for bean StockTransSource
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.StockTransSource ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean StockTransSource
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockTransSourceTest 
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
		
		System.out.println("Checking class StockTransSource getters and setters ..." );
		
		StockTransSource stockTransSource = new StockTransSource();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		stockTransSource.setId( integerValue ) ;
		Assert.assertTrue( integerValue == stockTransSource.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		stockTransSource.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockTransSource.getName() ) ) ;

		//--- Test setter/getter for field "suitableRight"  ( type : String )
		// System.out.println(" checking field suitableRight ..." );
		stockTransSource.setSuitableRight( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockTransSource.getSuitableRight() ) ) ;

		//--- Test setter/getter for field "hasCostEffect"  ( type : Boolean )
		// System.out.println(" checking field hasCostEffect ..." );
		stockTransSource.setHasCostEffect( true ) ;
		Assert.assertTrue( stockTransSource.getHasCostEffect() ) ;
		stockTransSource.setHasCostEffect( false ) ;
		Assert.assertFalse( stockTransSource.getHasCostEffect() ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		stockTransSource.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockTransSource.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		stockTransSource.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockTransSource.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		stockTransSource.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockTransSource.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		stockTransSource.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockTransSource.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		stockTransSource.setIsActive( true ) ;
		Assert.assertTrue( stockTransSource.getIsActive() ) ;
		stockTransSource.setIsActive( false ) ;
		Assert.assertFalse( stockTransSource.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		stockTransSource.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == stockTransSource.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		stockTransSource.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == stockTransSource.getVersion() ) ;

		
	}



}