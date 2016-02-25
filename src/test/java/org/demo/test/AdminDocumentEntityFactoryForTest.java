package org.demo.test;

import org.demo.bean.jpa.AdminDocumentEntity;

public class AdminDocumentEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocumentEntity newAdminDocumentEntity() {

		Integer id = mockValues.nextInteger();

		AdminDocumentEntity adminDocumentEntity = new AdminDocumentEntity();
		adminDocumentEntity.setId(id);
		return adminDocumentEntity;
	}
	
}
