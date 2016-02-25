package org.demo.test;

import org.demo.bean.jpa.InvoiceTransTaxEntity;

public class InvoiceTransTaxEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransTaxEntity newInvoiceTransTaxEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransTaxEntity invoiceTransTaxEntity = new InvoiceTransTaxEntity();
		invoiceTransTaxEntity.setId(id);
		return invoiceTransTaxEntity;
	}
	
}
