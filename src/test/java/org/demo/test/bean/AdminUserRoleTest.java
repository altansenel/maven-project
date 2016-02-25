/*
 * JUnit test case for bean AdminUserRole
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.AdminUserRole ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean AdminUserRole
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminUserRoleTest 
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
		
		System.out.println("Checking class AdminUserRole getters and setters ..." );
		
		AdminUserRole adminUserRole = new AdminUserRole();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		adminUserRole.setId( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserRole.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		adminUserRole.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminUserRole.getName() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		adminUserRole.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminUserRole.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		adminUserRole.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( adminUserRole.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		adminUserRole.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminUserRole.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		adminUserRole.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( adminUserRole.getUpdateAt() ) );

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		adminUserRole.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserRole.getVersion() ) ;

		
	}



}