package org.demo.test;

import org.demo.bean.jpa.InvoiceTransCurrencyEntity;

public class InvoiceTransCurrencyEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransCurrencyEntity newInvoiceTransCurrencyEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransCurrencyEntity invoiceTransCurrencyEntity = new InvoiceTransCurrencyEntity();
		invoiceTransCurrencyEntity.setId(id);
		return invoiceTransCurrencyEntity;
	}
	
}
