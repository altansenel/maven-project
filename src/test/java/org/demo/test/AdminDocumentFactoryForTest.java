package org.demo.test;

import org.demo.bean.AdminDocument;

public class AdminDocumentFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocument newAdminDocument() {

		Integer id = mockValues.nextInteger();

		AdminDocument adminDocument = new AdminDocument();
		adminDocument.setId(id);
		return adminDocument;
	}
	
}
