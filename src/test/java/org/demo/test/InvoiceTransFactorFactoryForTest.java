package org.demo.test;

import org.demo.bean.InvoiceTransFactor;

public class InvoiceTransFactorFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransFactor newInvoiceTransFactor() {

		Integer id = mockValues.nextInteger();

		InvoiceTransFactor invoiceTransFactor = new InvoiceTransFactor();
		invoiceTransFactor.setId(id);
		return invoiceTransFactor;
	}
	
}
