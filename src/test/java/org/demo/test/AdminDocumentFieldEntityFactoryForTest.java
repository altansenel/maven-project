package org.demo.test;

import org.demo.bean.jpa.AdminDocumentFieldEntity;

public class AdminDocumentFieldEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocumentFieldEntity newAdminDocumentFieldEntity() {

		Integer id = mockValues.nextInteger();

		AdminDocumentFieldEntity adminDocumentFieldEntity = new AdminDocumentFieldEntity();
		adminDocumentFieldEntity.setId(id);
		return adminDocumentFieldEntity;
	}
	
}
