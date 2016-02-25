package org.demo.test;

import org.demo.bean.InvoiceTransStatus;

public class InvoiceTransStatusFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransStatus newInvoiceTransStatus() {

		Integer id = mockValues.nextInteger();

		InvoiceTransStatus invoiceTransStatus = new InvoiceTransStatus();
		invoiceTransStatus.setId(id);
		return invoiceTransStatus;
	}
	
}
