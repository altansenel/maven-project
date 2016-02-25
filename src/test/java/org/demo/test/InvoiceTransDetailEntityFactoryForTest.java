package org.demo.test;

import org.demo.bean.jpa.InvoiceTransDetailEntity;

public class InvoiceTransDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransDetailEntity newInvoiceTransDetailEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransDetailEntity invoiceTransDetailEntity = new InvoiceTransDetailEntity();
		invoiceTransDetailEntity.setId(id);
		return invoiceTransDetailEntity;
	}
	
}
