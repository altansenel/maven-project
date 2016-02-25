/*
 * JUnit test case for bean AdminUserGivenRole
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.AdminUserGivenRole ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean AdminUserGivenRole
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminUserGivenRoleTest 
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
		
		System.out.println("Checking class AdminUserGivenRole getters and setters ..." );
		
		AdminUserGivenRole adminUserGivenRole = new AdminUserGivenRole();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		adminUserGivenRole.setId( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserGivenRole.getId() ) ;

		//--- Test setter/getter for field "userGroupId"  ( type : Integer )
		// System.out.println(" checking field userGroupId ..." );
		adminUserGivenRole.setUserGroupId( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserGivenRole.getUserGroupId() ) ;

		//--- Test setter/getter for field "workspaceId"  ( type : Integer )
		// System.out.println(" checking field workspaceId ..." );
		adminUserGivenRole.setWorkspaceId( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserGivenRole.getWorkspaceId() ) ;

		//--- Test setter/getter for field "userRoleId"  ( type : Integer )
		// System.out.println(" checking field userRoleId ..." );
		adminUserGivenRole.setUserRoleId( integerValue ) ;
		Assert.assertTrue( integerValue == adminUserGivenRole.getUserRoleId() ) ;

		
	}



}
