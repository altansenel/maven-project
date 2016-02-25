package org.demo.test;

import org.demo.bean.jpa.InvoiceTransStatusEntity;

public class InvoiceTransStatusEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransStatusEntity newInvoiceTransStatusEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransStatusEntity invoiceTransStatusEntity = new InvoiceTransStatusEntity();
		invoiceTransStatusEntity.setId(id);
		return invoiceTransStatusEntity;
	}
	
}
