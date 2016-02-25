package org.demo.test;

import org.demo.bean.InvoiceTrans;

public class InvoiceTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTrans newInvoiceTrans() {

		Integer id = mockValues.nextInteger();

		InvoiceTrans invoiceTrans = new InvoiceTrans();
		invoiceTrans.setId(id);
		return invoiceTrans;
	}
	
}
