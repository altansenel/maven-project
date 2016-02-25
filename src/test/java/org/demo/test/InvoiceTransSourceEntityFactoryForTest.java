package org.demo.test;

import org.demo.bean.jpa.InvoiceTransSourceEntity;

public class InvoiceTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransSourceEntity newInvoiceTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransSourceEntity invoiceTransSourceEntity = new InvoiceTransSourceEntity();
		invoiceTransSourceEntity.setId(id);
		return invoiceTransSourceEntity;
	}
	
}
