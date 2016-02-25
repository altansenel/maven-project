/*
 * JUnit test case for InvoiceTransTax caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.InvoiceTransTax ;
import org.demo.cache.InvoiceTransTaxCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for InvoiceTransTax caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class InvoiceTransTaxCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(InvoiceTransTax invoiceTransTax) {
		invoiceTransTax.setId( 1 ) ;
		invoiceTransTax.setTaxRate( 12.345 ) ;
		invoiceTransTax.setBasis( 12.345 ) ;
		invoiceTransTax.setAmount( 12.345 ) ;
		invoiceTransTax.setTransId( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class InvoiceTransTaxCache ..." );
		
		InvoiceTransTax invoiceTransTax = new InvoiceTransTax();
		populate(invoiceTransTax);
		System.out.println("Entity populated : " + invoiceTransTax );
		
		InvoiceTransTaxCache.putInvoiceTransTax(invoiceTransTax) ;	// Store in cache	
		
		InvoiceTransTax invoiceTransTax2 = InvoiceTransTaxCache.getInvoiceTransTax( invoiceTransTax.getId() );
		Assert.assertTrue( invoiceTransTax == invoiceTransTax2 ) ; // Same instance
		
		InvoiceTransTaxCache.removeInvoiceTransTax(  invoiceTransTax.getId() ) ; // Remove from cache	
		
		InvoiceTransTax invoiceTransTax3 = InvoiceTransTaxCache.getInvoiceTransTax( invoiceTransTax.getId() );
		Assert.assertTrue( null == invoiceTransTax3 ) ; // Not in cache
		
	}
}
