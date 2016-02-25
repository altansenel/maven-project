package org.demo.test;

import org.demo.bean.jpa.InvoiceTransEntity;

public class InvoiceTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransEntity newInvoiceTransEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransEntity invoiceTransEntity = new InvoiceTransEntity();
		invoiceTransEntity.setId(id);
		return invoiceTransEntity;
	}
	
}
