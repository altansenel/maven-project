/*
 * JUnit test case for bean GlobalPrivateCode
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.GlobalPrivateCode ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean GlobalPrivateCode
 * 
 * @author Telosys Tools Generator
 *
 */
public class GlobalPrivateCodeTest 
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
		
		System.out.println("Checking class GlobalPrivateCode getters and setters ..." );
		
		GlobalPrivateCode globalPrivateCode = new GlobalPrivateCode();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		globalPrivateCode.setId( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getId() ) ;

		//--- Test setter/getter for field "par1id"  ( type : Integer )
		// System.out.println(" checking field par1id ..." );
		globalPrivateCode.setPar1id( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getPar1id() ) ;

		//--- Test setter/getter for field "par2id"  ( type : Integer )
		// System.out.println(" checking field par2id ..." );
		globalPrivateCode.setPar2id( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getPar2id() ) ;

		//--- Test setter/getter for field "par3id"  ( type : Integer )
		// System.out.println(" checking field par3id ..." );
		globalPrivateCode.setPar3id( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getPar3id() ) ;

		//--- Test setter/getter for field "par4id"  ( type : Integer )
		// System.out.println(" checking field par4id ..." );
		globalPrivateCode.setPar4id( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getPar4id() ) ;

		//--- Test setter/getter for field "par5id"  ( type : Integer )
		// System.out.println(" checking field par5id ..." );
		globalPrivateCode.setPar5id( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getPar5id() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		globalPrivateCode.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( globalPrivateCode.getName() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		globalPrivateCode.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( globalPrivateCode.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		globalPrivateCode.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( globalPrivateCode.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		globalPrivateCode.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( globalPrivateCode.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		globalPrivateCode.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( globalPrivateCode.getUpdateAt() ) );

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		globalPrivateCode.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		globalPrivateCode.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == globalPrivateCode.getVersion() ) ;

		
	}



}
