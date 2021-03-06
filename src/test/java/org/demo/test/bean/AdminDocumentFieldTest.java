/*
 * JUnit test case for bean AdminDocumentField
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.AdminDocumentField ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean AdminDocumentField
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdminDocumentFieldTest 
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
		
		System.out.println("Checking class AdminDocumentField getters and setters ..." );
		
		AdminDocumentField adminDocumentField = new AdminDocumentField();
		
		//--- Test setter/getter for field "id"  ( type : Integer )
		// System.out.println(" checking field id ..." );
		adminDocumentField.setId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getId() ) ;

		//--- Test setter/getter for field "module"  ( type : String )
		// System.out.println(" checking field module ..." );
		adminDocumentField.setModule( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getModule() ) ) ;

		//--- Test setter/getter for field "band"  ( type : String )
		// System.out.println(" checking field band ..." );
		adminDocumentField.setBand( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getBand() ) ) ;

		//--- Test setter/getter for field "type"  ( type : String )
		// System.out.println(" checking field type ..." );
		adminDocumentField.setType( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getType() ) ) ;

		//--- Test setter/getter for field "name"  ( type : String )
		// System.out.println(" checking field name ..." );
		adminDocumentField.setName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getName() ) ) ;

		//--- Test setter/getter for field "nickName"  ( type : String )
		// System.out.println(" checking field nickName ..." );
		adminDocumentField.setNickName( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getNickName() ) ) ;

		//--- Test setter/getter for field "hiddenField"  ( type : String )
		// System.out.println(" checking field hiddenField ..." );
		adminDocumentField.setHiddenField( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getHiddenField() ) ) ;

		//--- Test setter/getter for field "label"  ( type : String )
		// System.out.println(" checking field label ..." );
		adminDocumentField.setLabel( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getLabel() ) ) ;

		//--- Test setter/getter for field "originalLabel"  ( type : String )
		// System.out.println(" checking field originalLabel ..." );
		adminDocumentField.setOriginalLabel( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getOriginalLabel() ) ) ;

		//--- Test setter/getter for field "labelWidth"  ( type : Integer )
		// System.out.println(" checking field labelWidth ..." );
		adminDocumentField.setLabelWidth( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getLabelWidth() ) ;

		//--- Test setter/getter for field "labelAlign"  ( type : String )
		// System.out.println(" checking field labelAlign ..." );
		adminDocumentField.setLabelAlign( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getLabelAlign() ) ) ;

		//--- Test setter/getter for field "width"  ( type : Integer )
		// System.out.println(" checking field width ..." );
		adminDocumentField.setWidth( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getWidth() ) ;

		//--- Test setter/getter for field "row"  ( type : Integer )
		// System.out.println(" checking field row ..." );
		adminDocumentField.setRow( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getRow() ) ;

		//--- Test setter/getter for field "column"  ( type : Integer )
		// System.out.println(" checking field column ..." );
		adminDocumentField.setColumn( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getColumn() ) ;

		//--- Test setter/getter for field "format"  ( type : String )
		// System.out.println(" checking field format ..." );
		adminDocumentField.setFormat( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getFormat() ) ) ;

		//--- Test setter/getter for field "prefix"  ( type : String )
		// System.out.println(" checking field prefix ..." );
		adminDocumentField.setPrefix( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getPrefix() ) ) ;

		//--- Test setter/getter for field "suffix"  ( type : String )
		// System.out.println(" checking field suffix ..." );
		adminDocumentField.setSuffix( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getSuffix() ) ) ;

		//--- Test setter/getter for field "value"  ( type : String )
		// System.out.println(" checking field value ..." );
		adminDocumentField.setValue( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getValue() ) ) ;

		//--- Test setter/getter for field "msgPrefix"  ( type : String )
		// System.out.println(" checking field msgPrefix ..." );
		adminDocumentField.setMsgPrefix( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getMsgPrefix() ) ) ;

		//--- Test setter/getter for field "defauld"  ( type : String )
		// System.out.println(" checking field defauld ..." );
		adminDocumentField.setDefauld( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getDefauld() ) ) ;

		//--- Test setter/getter for field "isDbField"  ( type : Boolean )
		// System.out.println(" checking field isDbField ..." );
		adminDocumentField.setIsDbField( true ) ;
		Assert.assertTrue( adminDocumentField.getIsDbField() ) ;
		adminDocumentField.setIsDbField( false ) ;
		Assert.assertFalse( adminDocumentField.getIsDbField() ) ;

		//--- Test setter/getter for field "tableType"  ( type : String )
		// System.out.println(" checking field tableType ..." );
		adminDocumentField.setTableType( stringValue ) ;
		Assert.assertTrue( stringValue.equals( adminDocumentField.getTableType() ) ) ;

		//--- Test setter/getter for field "reportTitleDocId"  ( type : Integer )
		// System.out.println(" checking field reportTitleDocId ..." );
		adminDocumentField.setReportTitleDocId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getReportTitleDocId() ) ;

		//--- Test setter/getter for field "pageTitleDocId"  ( type : Integer )
		// System.out.println(" checking field pageTitleDocId ..." );
		adminDocumentField.setPageTitleDocId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getPageTitleDocId() ) ;

		//--- Test setter/getter for field "detailDocId"  ( type : Integer )
		// System.out.println(" checking field detailDocId ..." );
		adminDocumentField.setDetailDocId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getDetailDocId() ) ;

		//--- Test setter/getter for field "pageFooterDocId"  ( type : Integer )
		// System.out.println(" checking field pageFooterDocId ..." );
		adminDocumentField.setPageFooterDocId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getPageFooterDocId() ) ;

		//--- Test setter/getter for field "reportFooterDocId"  ( type : Integer )
		// System.out.println(" checking field reportFooterDocId ..." );
		adminDocumentField.setReportFooterDocId( integerValue ) ;
		Assert.assertTrue( integerValue == adminDocumentField.getReportFooterDocId() ) ;

		
	}



}
