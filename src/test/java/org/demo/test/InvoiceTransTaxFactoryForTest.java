package org.demo.test;

import org.demo.bean.InvoiceTransTax;

public class InvoiceTransTaxFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransTax newInvoiceTransTax() {

		Integer id = mockValues.nextInteger();

		InvoiceTransTax invoiceTransTax = new InvoiceTransTax();
		invoiceTransTax.setId(id);
		return invoiceTransTax;
	}
	
}
