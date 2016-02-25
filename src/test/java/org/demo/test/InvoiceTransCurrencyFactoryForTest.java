package org.demo.test;

import org.demo.bean.InvoiceTransCurrency;

public class InvoiceTransCurrencyFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransCurrency newInvoiceTransCurrency() {

		Integer id = mockValues.nextInteger();

		InvoiceTransCurrency invoiceTransCurrency = new InvoiceTransCurrency();
		invoiceTransCurrency.setId(id);
		return invoiceTransCurrency;
	}
	
}
