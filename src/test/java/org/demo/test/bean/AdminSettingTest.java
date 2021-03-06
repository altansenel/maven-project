/*
 * JUnit test case for bean AdminSetting
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.AdminSetting ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean AdminSetting
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminSettingTest 
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
		
		System.out.println("Checking class AdminSetting getters and setters ..." );
		
		AdminSetting adminSetting = new AdminSetting();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		adminSetting.setId( integerValue ) ;
		Assert.assertTrue( integerValue == adminSetting.getId() ) ;

		//--- Test setter/getter for field "code"  ( type : String )
		// System.out.println(" checking field code ..." );
		adminSetting.setCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminSetting.getCode() ) ) ;

		//--- Test setter/getter for field "description"  ( type : String )
		// System.out.println(" checking field description ..." );
		adminSetting.setDescription( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminSetting.getDescription() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		adminSetting.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminSetting.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		adminSetting.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( adminSetting.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		adminSetting.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminSetting.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		adminSetting.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( adminSetting.getUpdateAt() ) );

		//--- Test setter/getter for field "jsonData"  ( type : String )
		// System.out.println(" checking field jsonData ..." );
		adminSetting.setJsonData( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminSetting.getJsonData() ) ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		adminSetting.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == adminSetting.getVersion() ) ;

		
	}



}
