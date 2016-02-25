/*
 * JUnit test case for bean InvoiceTransStatusHistory
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.InvoiceTransStatusHistory ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean InvoiceTransStatusHistory
 * 
 * @author Telosys Tools Generator
 *
 */
public class InvoiceTransStatusHistoryTest 
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
		
		System.out.println("Checking class InvoiceTransStatusHistory getters and setters ..." );
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = new InvoiceTransStatusHistory();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		invoiceTransStatusHistory.setId( integerValue ) ;
		Assert.assertTrue( integerValue == invoiceTransStatusHistory.getId() ) ;

		//--- Test setter/getter for field "transTime"  ( type : Date )
		// System.out.println(" checking field transTime ..." );
		invoiceTransStatusHistory.setTransTime( dateValue ) ;
		Assert.assertTrue( dateValue.equals( invoiceTransStatusHistory.getTransTime() ) );

		//--- Test setter/getter for field "transId"  ( type : Integer )
		// System.out.println(" checking field transId ..." );
		invoiceTransStatusHistory.setTransId( integerValue ) ;
		Assert.assertTrue( integerValue == invoiceTransStatusHistory.getTransId() ) ;

		//--- Test setter/getter for field "statusId"  ( type : Integer )
		// System.out.println(" checking field statusId ..." );
		invoiceTransStatusHistory.setStatusId( integerValue ) ;
		Assert.assertTrue( integerValue == invoiceTransStatusHistory.getStatusId() ) ;

		//--- Test setter/getter for field "username"  ( type : String )
		// System.out.println(" checking field username ..." );
		invoiceTransStatusHistory.setUsername( stringValue ) ;
		Assert.assertTrue( stringValue.equals( invoiceTransStatusHistory.getUsername() ) ) ;

		//--- Test setter/getter for field "description"  ( type : String )
		// System.out.println(" checking field description ..." );
		invoiceTransStatusHistory.setDescription( stringValue ) ;
		Assert.assertTrue( stringValue.equals( invoiceTransStatusHistory.getDescription() ) ) ;

		
	}



}