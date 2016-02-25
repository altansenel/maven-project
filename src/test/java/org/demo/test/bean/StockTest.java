/*
 * JUnit test case for bean Stock
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.Stock ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean Stock
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockTest 
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
		
		System.out.println("Checking class Stock getters and setters ..." );
		
		Stock stock = new Stock();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		stock.setId( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getId() ) ;

		//--- Test setter/getter for field "code"  ( type : String )
		// System.out.println(" checking field code ..." );
		stock.setCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getCode() ) ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		stock.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getName() ) ) ;

		//--- Test setter/getter for field "excCode"  ( type : String )
		// System.out.println(" checking field excCode ..." );
		stock.setExcCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getExcCode() ) ) ;

		//--- Test setter/getter for field "providerCode"  ( type : String )
		// System.out.println(" checking field providerCode ..." );
		stock.setProviderCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getProviderCode() ) ) ;

		//--- Test setter/getter for field "unit1"  ( type : String )
		// System.out.println(" checking field unit1 ..." );
		stock.setUnit1( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getUnit1() ) ) ;

		//--- Test setter/getter for field "unit2"  ( type : String )
		// System.out.println(" checking field unit2 ..." );
		stock.setUnit2( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getUnit2() ) ) ;

		//--- Test setter/getter for field "unit3"  ( type : String )
		// System.out.println(" checking field unit3 ..." );
		stock.setUnit3( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getUnit3() ) ) ;

		//--- Test setter/getter for field "unit2ratio"  ( type : Double )
		// System.out.println(" checking field unit2ratio ..." );
		stock.setUnit2ratio( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getUnit2ratio() ) ;

		//--- Test setter/getter for field "unit3ratio"  ( type : Double )
		// System.out.println(" checking field unit3ratio ..." );
		stock.setUnit3ratio( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getUnit3ratio() ) ;

		//--- Test setter/getter for field "buyPrice"  ( type : Double )
		// System.out.println(" checking field buyPrice ..." );
		stock.setBuyPrice( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getBuyPrice() ) ;

		//--- Test setter/getter for field "sellPrice"  ( type : Double )
		// System.out.println(" checking field sellPrice ..." );
		stock.setSellPrice( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getSellPrice() ) ;

		//--- Test setter/getter for field "buyTax"  ( type : Double )
		// System.out.println(" checking field buyTax ..." );
		stock.setBuyTax( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getBuyTax() ) ;

		//--- Test setter/getter for field "sellTax"  ( type : Double )
		// System.out.println(" checking field sellTax ..." );
		stock.setSellTax( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getSellTax() ) ;

		//--- Test setter/getter for field "taxRate2"  ( type : Double )
		// System.out.println(" checking field taxRate2 ..." );
		stock.setTaxRate2( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getTaxRate2() ) ;

		//--- Test setter/getter for field "taxRate3"  ( type : Double )
		// System.out.println(" checking field taxRate3 ..." );
		stock.setTaxRate3( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getTaxRate3() ) ;

		//--- Test setter/getter for field "primRate"  ( type : Double )
		// System.out.println(" checking field primRate ..." );
		stock.setPrimRate( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getPrimRate() ) ;

		//--- Test setter/getter for field "maxLimit"  ( type : Double )
		// System.out.println(" checking field maxLimit ..." );
		stock.setMaxLimit( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getMaxLimit() ) ;

		//--- Test setter/getter for field "minLimit"  ( type : Double )
		// System.out.println(" checking field minLimit ..." );
		stock.setMinLimit( doubleValue ) ;
		Assert.assertTrue( doubleValue == stock.getMinLimit() ) ;

		//--- Test setter/getter for field "note"  ( type : String )
		// System.out.println(" checking field note ..." );
		stock.setNote( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getNote() ) ) ;

		//--- Test setter/getter for field "categoryId"  ( type : Integer )
		// System.out.println(" checking field categoryId ..." );
		stock.setCategoryId( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getCategoryId() ) ;

		//--- Test setter/getter for field "extraField0Id"  ( type : Integer )
		// System.out.println(" checking field extraField0Id ..." );
		stock.setExtraField0Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField0Id() ) ;

		//--- Test setter/getter for field "extraField1Id"  ( type : Integer )
		// System.out.println(" checking field extraField1Id ..." );
		stock.setExtraField1Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField1Id() ) ;

		//--- Test setter/getter for field "extraField2Id"  ( type : Integer )
		// System.out.println(" checking field extraField2Id ..." );
		stock.setExtraField2Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField2Id() ) ;

		//--- Test setter/getter for field "extraField3Id"  ( type : Integer )
		// System.out.println(" checking field extraField3Id ..." );
		stock.setExtraField3Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField3Id() ) ;

		//--- Test setter/getter for field "extraField4Id"  ( type : Integer )
		// System.out.println(" checking field extraField4Id ..." );
		stock.setExtraField4Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField4Id() ) ;

		//--- Test setter/getter for field "extraField5Id"  ( type : Integer )
		// System.out.println(" checking field extraField5Id ..." );
		stock.setExtraField5Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField5Id() ) ;

		//--- Test setter/getter for field "extraField6Id"  ( type : Integer )
		// System.out.println(" checking field extraField6Id ..." );
		stock.setExtraField6Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField6Id() ) ;

		//--- Test setter/getter for field "extraField7Id"  ( type : Integer )
		// System.out.println(" checking field extraField7Id ..." );
		stock.setExtraField7Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField7Id() ) ;

		//--- Test setter/getter for field "extraField8Id"  ( type : Integer )
		// System.out.println(" checking field extraField8Id ..." );
		stock.setExtraField8Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField8Id() ) ;

		//--- Test setter/getter for field "extraField9Id"  ( type : Integer )
		// System.out.println(" checking field extraField9Id ..." );
		stock.setExtraField9Id( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getExtraField9Id() ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		stock.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		stock.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stock.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		stock.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stock.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		stock.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stock.getUpdateAt() ) );

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		stock.setIsActive( true ) ;
		Assert.assertTrue( stock.getIsActive() ) ;
		stock.setIsActive( false ) ;
		Assert.assertFalse( stock.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		stock.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		stock.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == stock.getVersion() ) ;

		
	}



}
