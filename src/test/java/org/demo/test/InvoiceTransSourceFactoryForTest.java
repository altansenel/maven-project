package org.demo.test;

import org.demo.bean.InvoiceTransSource;

public class InvoiceTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransSource newInvoiceTransSource() {

		Integer id = mockValues.nextInteger();

		InvoiceTransSource invoiceTransSource = new InvoiceTransSource();
		invoiceTransSource.setId(id);
		return invoiceTransSource;
	}
	
}
