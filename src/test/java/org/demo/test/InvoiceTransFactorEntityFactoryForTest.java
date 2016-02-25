package org.demo.test;

import org.demo.bean.jpa.InvoiceTransFactorEntity;

public class InvoiceTransFactorEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransFactorEntity newInvoiceTransFactorEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransFactorEntity invoiceTransFactorEntity = new InvoiceTransFactorEntity();
		invoiceTransFactorEntity.setId(id);
		return invoiceTransFactorEntity;
	}
	
}
