/*
 * JUnit test case for bean ContactCategory
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ContactCategory ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ContactCategory
 * 
 * @author Telosys Tools Generator
 *
 */
public class ContactCategoryTest 
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
		
		System.out.println("Checking class ContactCategory getters and setters ..." );
		
		ContactCategory contactCategory = new ContactCategory();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		contactCategory.setId( integerValue ) ;
		Assert.assertTrue( integerValue == contactCategory.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		contactCategory.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactCategory.getName() ) ) ;

		//--- Test setter/getter for field "workingDir"  ( type : String )
		// System.out.println(" checking field workingDir ..." );
		contactCategory.setWorkingDir( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactCategory.getWorkingDir() ) ) ;

		//--- Test setter/getter for field "debtLimit"  ( type : Double )
		// System.out.println(" checking field debtLimit ..." );
		contactCategory.setDebtLimit( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactCategory.getDebtLimit() ) ;

		//--- Test setter/getter for field "creditLimit"  ( type : Double )
		// System.out.println(" checking field creditLimit ..." );
		contactCategory.setCreditLimit( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactCategory.getCreditLimit() ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		contactCategory.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactCategory.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		contactCategory.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactCategory.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		contactCategory.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactCategory.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		contactCategory.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactCategory.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		contactCategory.setIsActive( true ) ;
		Assert.assertTrue( contactCategory.getIsActive() ) ;
		contactCategory.setIsActive( false ) ;
		Assert.assertFalse( contactCategory.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		contactCategory.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == contactCategory.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		contactCategory.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == contactCategory.getVersion() ) ;

		
	}



}
