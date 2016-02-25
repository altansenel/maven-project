package org.demo.test;

import org.demo.bean.AdminDocumentTarget;

public class AdminDocumentTargetFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminDocumentTarget newAdminDocumentTarget() {

		Integer id = mockValues.nextInteger();

		AdminDocumentTarget adminDocumentTarget = new AdminDocumentTarget();
		adminDocumentTarget.setId(id);
		return adminDocumentTarget;
	}
	
}
