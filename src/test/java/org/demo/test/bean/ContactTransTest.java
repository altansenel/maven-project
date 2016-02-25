/*
 * JUnit test case for bean ContactTrans
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.ContactTrans ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean ContactTrans
 * 
 * @author Telosys Tools Generator
 *
 */
public class ContactTransTest 
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
		
		System.out.println("Checking class ContactTrans getters and setters ..." );
		
		ContactTrans contactTrans = new ContactTrans();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		contactTrans.setId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getId() ) ;

		//--- Test setter/getter for field "receiptNo"  ( type : Integer )
		// System.out.println(" checking field receiptNo ..." );
		contactTrans.setReceiptNo( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getReceiptNo() ) ;

		//--- Test setter/getter for field "right"  ( type : String )
		// System.out.println(" checking field right ..." );
		contactTrans.setRight( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getRight() ) ) ;

		//--- Test setter/getter for field "transDate"  ( type : Date )
		// System.out.println(" checking field transDate ..." );
		contactTrans.setTransDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactTrans.getTransDate() ) );

		//--- Test setter/getter for field "maturity"  ( type : Date )
		// System.out.println(" checking field maturity ..." );
		contactTrans.setMaturity( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactTrans.getMaturity() ) );

		//--- Test setter/getter for field "transNo"  ( type : String )
		// System.out.println(" checking field transNo ..." );
		contactTrans.setTransNo( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getTransNo() ) ) ;

		//--- Test setter/getter for field "transType"  ( type : String )
		// System.out.println(" checking field transType ..." );
		contactTrans.setTransType( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getTransType() ) ) ;

		//--- Test setter/getter for field "amount"  ( type : Double )
		// System.out.println(" checking field amount ..." );
		contactTrans.setAmount( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactTrans.getAmount() ) ;

		//--- Test setter/getter for field "debt"  ( type : Double )
		// System.out.println(" checking field debt ..." );
		contactTrans.setDebt( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactTrans.getDebt() ) ;

		//--- Test setter/getter for field "credit"  ( type : Double )
		// System.out.println(" checking field credit ..." );
		contactTrans.setCredit( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactTrans.getCredit() ) ;

		//--- Test setter/getter for field "description"  ( type : String )
		// System.out.println(" checking field description ..." );
		contactTrans.setDescription( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getDescription() ) ) ;

		//--- Test setter/getter for field "transYear"  ( type : Integer )
		// System.out.println(" checking field transYear ..." );
		contactTrans.setTransYear( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getTransYear() ) ;

		//--- Test setter/getter for field "transMonth"  ( type : String )
		// System.out.println(" checking field transMonth ..." );
		contactTrans.setTransMonth( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getTransMonth() ) ) ;

		//--- Test setter/getter for field "excCode"  ( type : String )
		// System.out.println(" checking field excCode ..." );
		contactTrans.setExcCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getExcCode() ) ) ;

		//--- Test setter/getter for field "excRate"  ( type : Double )
		// System.out.println(" checking field excRate ..." );
		contactTrans.setExcRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactTrans.getExcRate() ) ;

		//--- Test setter/getter for field "excEquivalent"  ( type : Double )
		// System.out.println(" checking field excEquivalent ..." );
		contactTrans.setExcEquivalent( doubleValue ) ;
		Assert.assertTrue( doubleValue == contactTrans.getExcEquivalent() ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		contactTrans.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		contactTrans.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactTrans.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		contactTrans.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		contactTrans.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( contactTrans.getUpdateAt() ) );

		//--- Test setter/getter for field "transSourceId"  ( type : Integer )
		// System.out.println(" checking field transSourceId ..." );
		contactTrans.setTransSourceId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getTransSourceId() ) ;

		//--- Test setter/getter for field "transPointId"  ( type : Integer )
		// System.out.println(" checking field transPointId ..." );
		contactTrans.setTransPointId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getTransPointId() ) ;

		//--- Test setter/getter for field "privateCodeId"  ( type : Integer )
		// System.out.println(" checking field privateCodeId ..." );
		contactTrans.setPrivateCodeId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getPrivateCodeId() ) ;

		//--- Test setter/getter for field "contactId"  ( type : Integer )
		// System.out.println(" checking field contactId ..." );
		contactTrans.setContactId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getContactId() ) ;

		//--- Test setter/getter for field "refModule"  ( type : String )
		// System.out.println(" checking field refModule ..." );
		contactTrans.setRefModule( stringValue ) ;
		Assert.assertTrue( stringValue.equals( contactTrans.getRefModule() ) ) ;

		//--- Test setter/getter for field "refId"  ( type : Integer )
		// System.out.println(" checking field refId ..." );
		contactTrans.setRefId( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getRefId() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		contactTrans.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		contactTrans.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == contactTrans.getVersion() ) ;

		
	}



}
