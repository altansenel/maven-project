package org.demo.test;

import org.demo.bean.jpa.InvoiceTransStatusHistoryEntity;

public class InvoiceTransStatusHistoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransStatusHistoryEntity newInvoiceTransStatusHistoryEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransStatusHistoryEntity invoiceTransStatusHistoryEntity = new InvoiceTransStatusHistoryEntity();
		invoiceTransStatusHistoryEntity.setId(id);
		return invoiceTransStatusHistoryEntity;
	}
	
}
