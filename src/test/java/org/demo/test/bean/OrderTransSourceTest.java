/*
 * JUnit test case for bean OrderTransSource
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.OrderTransSource ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean OrderTransSource
 * 
 * @author Telosys Tools Generator
 *
 */
public class OrderTransSourceTest 
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
		
		System.out.println("Checking class OrderTransSource getters and setters ..." );
		
		OrderTransSource orderTransSource = new OrderTransSource();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		orderTransSource.setId( integerValue ) ;
		Assert.assertTrue( integerValue == orderTransSource.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		orderTransSource.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( orderTransSource.getName() ) ) ;

		//--- Test setter/getter for field "suitableRight"  ( type : String )
		// System.out.println(" checking field suitableRight ..." );
		orderTransSource.setSuitableRight( stringValue ) ;
		Assert.assertTrue( stringValue.equals( orderTransSource.getSuitableRight() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		orderTransSource.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( orderTransSource.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		orderTransSource.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( orderTransSource.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		orderTransSource.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( orderTransSource.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		orderTransSource.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( orderTransSource.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		orderTransSource.setIsActive( true ) ;
		Assert.assertTrue( orderTransSource.getIsActive() ) ;
		orderTransSource.setIsActive( false ) ;
		Assert.assertFalse( orderTransSource.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		orderTransSource.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == orderTransSource.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		orderTransSource.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == orderTransSource.getVersion() ) ;

		
	}



}
