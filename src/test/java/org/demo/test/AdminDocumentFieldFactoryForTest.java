package org.demo.test;

import org.demo.bean.AdminDocumentField;

public class AdminDocumentFieldFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocumentField newAdminDocumentField() {

		Integer id = mockValues.nextInteger();

		AdminDocumentField adminDocumentField = new AdminDocumentField();
		adminDocumentField.setId(id);
		return adminDocumentField;
	}
	
}
