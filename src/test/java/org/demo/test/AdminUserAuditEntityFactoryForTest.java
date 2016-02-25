package org.demo.test;

import org.demo.bean.jpa.AdminUserAuditEntity;

public class AdminUserAuditEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserAuditEntity newAdminUserAuditEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserAuditEntity adminUserAuditEntity = new AdminUserAuditEntity();
		adminUserAuditEntity.setId(id);
		return adminUserAuditEntity;
	}
	
}
