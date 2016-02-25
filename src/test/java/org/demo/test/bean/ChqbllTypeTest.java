/*
 * JUnit test case for bean ChqbllType
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ChqbllType ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ChqbllType
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllTypeTest 
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
		
		System.out.println("Checking class ChqbllType getters and setters ..." );
		
		ChqbllType chqbllType = new ChqbllType();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		chqbllType.setId( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllType.getId() ) ;

		//--- Test setter/getter for field "sort"  ( type : String )
		// System.out.println(" checking field sort ..." );
		chqbllType.setSort( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllType.getSort() ) ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		chqbllType.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllType.getName() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		chqbllType.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllType.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		chqbllType.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllType.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		chqbllType.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( chqbllType.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		chqbllType.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( chqbllType.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		chqbllType.setIsActive( true ) ;
		Assert.assertTrue( chqbllType.getIsActive() ) ;
		chqbllType.setIsActive( false ) ;
		Assert.assertFalse( chqbllType.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		chqbllType.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllType.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		chqbllType.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == chqbllType.getVersion() ) ;

		
	}



}
