/*
 * JUnit test case for bean StockPriceList
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.StockPriceList ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean StockPriceList
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockPriceListTest 
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
		
		System.out.println("Checking class StockPriceList getters and setters ..." );
		
		StockPriceList stockPriceList = new StockPriceList();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		stockPriceList.setId( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getId() ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		stockPriceList.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getName() ) ) ;

		//--- Test setter/getter for field "startDate"  ( type : Date )
		// System.out.println(" checking field startDate ..." );
		stockPriceList.setStartDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockPriceList.getStartDate() ) );

		//--- Test setter/getter for field "endDate"  ( type : Date )
		// System.out.println(" checking field endDate ..." );
		stockPriceList.setEndDate( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockPriceList.getEndDate() ) );

		//--- Test setter/getter for field "isSellPrice"  ( type : Boolean )
		// System.out.println(" checking field isSellPrice ..." );
		stockPriceList.setIsSellPrice( true ) ;
		Assert.assertTrue( stockPriceList.getIsSellPrice() ) ;
		stockPriceList.setIsSellPrice( false ) ;
		Assert.assertFalse( stockPriceList.getIsSellPrice() ) ;

		//--- Test setter/getter for field "effectType"  ( type : String )
		// System.out.println(" checking field effectType ..." );
		stockPriceList.setEffectType( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getEffectType() ) ) ;

		//--- Test setter/getter for field "effectDirection"  ( type : String )
		// System.out.println(" checking field effectDirection ..." );
		stockPriceList.setEffectDirection( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getEffectDirection() ) ) ;

		//--- Test setter/getter for field "effect"  ( type : Double )
		// System.out.println(" checking field effect ..." );
		stockPriceList.setEffect( doubleValue ) ;
		Assert.assertTrue( doubleValue == stockPriceList.getEffect() ) ;

		//--- Test setter/getter for field "description"  ( type : String )
		// System.out.println(" checking field description ..." );
		stockPriceList.setDescription( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getDescription() ) ) ;

		//--- Test setter/getter for field "providerCode"  ( type : String )
		// System.out.println(" checking field providerCode ..." );
		stockPriceList.setProviderCode( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getProviderCode() ) ) ;

		//--- Test setter/getter for field "insertBy"  ( type : String )
		// System.out.println(" checking field insertBy ..." );
		stockPriceList.setInsertBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getInsertBy() ) ) ;

		//--- Test setter/getter for field "insertAt"  ( type : Date )
		// System.out.println(" checking field insertAt ..." );
		stockPriceList.setInsertAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockPriceList.getInsertAt() ) );

		//--- Test setter/getter for field "updateBy"  ( type : String )
		// System.out.println(" checking field updateBy ..." );
		stockPriceList.setUpdateBy( stringValue ) ;
		Assert.assertTrue( stringValue.equals( stockPriceList.getUpdateBy() ) ) ;

		//--- Test setter/getter for field "updateAt"  ( type : Date )
		// System.out.println(" checking field updateAt ..." );
		stockPriceList.setUpdateAt( dateValue ) ;
		Assert.assertTrue( dateValue.equals( stockPriceList.getUpdateAt() ) );

		//--- Test setter/getter for field "categoryId"  ( type : Integer )
		// System.out.println(" checking field categoryId ..." );
		stockPriceList.setCategoryId( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getCategoryId() ) ;

		//--- Test setter/getter for field "extraField0Id"  ( type : Integer )
		// System.out.println(" checking field extraField0Id ..." );
		stockPriceList.setExtraField0Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField0Id() ) ;

		//--- Test setter/getter for field "extraField1Id"  ( type : Integer )
		// System.out.println(" checking field extraField1Id ..." );
		stockPriceList.setExtraField1Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField1Id() ) ;

		//--- Test setter/getter for field "extraField2Id"  ( type : Integer )
		// System.out.println(" checking field extraField2Id ..." );
		stockPriceList.setExtraField2Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField2Id() ) ;

		//--- Test setter/getter for field "extraField3Id"  ( type : Integer )
		// System.out.println(" checking field extraField3Id ..." );
		stockPriceList.setExtraField3Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField3Id() ) ;

		//--- Test setter/getter for field "extraField4Id"  ( type : Integer )
		// System.out.println(" checking field extraField4Id ..." );
		stockPriceList.setExtraField4Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField4Id() ) ;

		//--- Test setter/getter for field "extraField5Id"  ( type : Integer )
		// System.out.println(" checking field extraField5Id ..." );
		stockPriceList.setExtraField5Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField5Id() ) ;

		//--- Test setter/getter for field "extraField6Id"  ( type : Integer )
		// System.out.println(" checking field extraField6Id ..." );
		stockPriceList.setExtraField6Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField6Id() ) ;

		//--- Test setter/getter for field "extraField7Id"  ( type : Integer )
		// System.out.println(" checking field extraField7Id ..." );
		stockPriceList.setExtraField7Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField7Id() ) ;

		//--- Test setter/getter for field "extraField8Id"  ( type : Integer )
		// System.out.println(" checking field extraField8Id ..." );
		stockPriceList.setExtraField8Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField8Id() ) ;

		//--- Test setter/getter for field "extraField9Id"  ( type : Integer )
		// System.out.println(" checking field extraField9Id ..." );
		stockPriceList.setExtraField9Id( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getExtraField9Id() ) ;

		//--- Test setter/getter for field "isActive"  ( type : Boolean )
		// System.out.println(" checking field isActive ..." );
		stockPriceList.setIsActive( true ) ;
		Assert.assertTrue( stockPriceList.getIsActive() ) ;
		stockPriceList.setIsActive( false ) ;
		Assert.assertFalse( stockPriceList.getIsActive() ) ;

		//--- Test setter/getter for field "workspace"  ( type : Integer )
		// System.out.println(" checking field workspace ..." );
		stockPriceList.setWorkspace( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getWorkspace() ) ;

		//--- Test setter/getter for field "version"  ( type : Integer )
		// System.out.println(" checking field version ..." );
		stockPriceList.setVersion( integerValue ) ;
		Assert.assertTrue( integerValue == stockPriceList.getVersion() ) ;

		
	}



}
