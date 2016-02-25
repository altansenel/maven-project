package org.demo.test;

import org.demo.bean.InvoiceTransRelation;

public class InvoiceTransRelationFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InvoiceTransRelation newInvoiceTransRelation() {

		Integer id = mockValues.nextInteger();

		InvoiceTransRelation invoiceTransRelation = new InvoiceTransRelation();
		invoiceTransRelation.setId(id);
		return invoiceTransRelation;
	}
	
}
