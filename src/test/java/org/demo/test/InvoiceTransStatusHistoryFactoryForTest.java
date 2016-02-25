package org.demo.test;

import org.demo.bean.InvoiceTransStatusHistory;

public class InvoiceTransStatusHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransStatusHistory newInvoiceTransStatusHistory() {

		Integer id = mockValues.nextInteger();

		InvoiceTransStatusHistory invoiceTransStatusHistory = new InvoiceTransStatusHistory();
		invoiceTransStatusHistory.setId(id);
		return invoiceTransStatusHistory;
	}
	
}
