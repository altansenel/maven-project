/*
 * JUnit test case for bean StockExtraFields
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.StockExtraFields ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean StockExtraFields
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockExtraFieldsTest 
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
		
		System.out.println("Checking class StockExtraFields getters and setters ..." );
		
		StockExtraFields stockExtraFields = new StockExtraFields();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		stockExtraFields.setId( integerValue ) ;
		Assert.assertTrue( integerValue == stockExtraFields.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		stockExtraFields.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockExtraFields.getName() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		stockExtraFields.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockExtraFields.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		stockExtraFields.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockExtraFields.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		stockExtraFields.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockExtraFields.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		stockExtraFields.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockExtraFields.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		stockExtraFields.setIsActive( true ) ;
		Assert.assertTrue( stockExtraFields.getIsActive() ) ;
		stockExtraFields.setIsActive( false ) ;
		Assert.assertFalse( stockExtraFields.getIsActive() ) ;

		//--- Test setter/getter for field "extraFieldsId"  ( type : Integer )
		// System.out.println(" checking field extraFieldsId ..." );
		stockExtraFields.setExtraFieldsId( integerValue ) ;
		Assert.assertTrue( integerValue == stockExtraFields.getExtraFieldsId() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		stockExtraFields.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == stockExtraFields.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		stockExtraFields.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == stockExtraFields.getVersion() ) ;

		
	}



}
