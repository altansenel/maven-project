package org.demo.test;

import org.demo.bean.jpa.InvoiceTransRelationEntity;

public class InvoiceTransRelationEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransRelationEntity newInvoiceTransRelationEntity() {

		Integer id = mockValues.nextInteger();

		InvoiceTransRelationEntity invoiceTransRelationEntity = new InvoiceTransRelationEntity();
		invoiceTransRelationEntity.setId(id);
		return invoiceTransRelationEntity;
	}
	
}
