package org.demo.test;

import org.demo.bean.jpa.AdminDocumentTargetEntity;

public class AdminDocumentTargetEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocumentTargetEntity newAdminDocumentTargetEntity() {

		Integer id = mockValues.nextInteger();

		AdminDocumentTargetEntity adminDocumentTargetEntity = new AdminDocumentTargetEntity();
		adminDocumentTargetEntity.setId(id);
		return adminDocumentTargetEntity;
	}
	
}
