package org.demo.test;

import org.demo.bean.InvoiceTransDetail;

public class InvoiceTransDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransDetail newInvoiceTransDetail() {

		Integer id = mockValues.nextInteger();

		InvoiceTransDetail invoiceTransDetail = new InvoiceTransDetail();
		invoiceTransDetail.setId(id);
		return invoiceTransDetail;
	}
	
}
