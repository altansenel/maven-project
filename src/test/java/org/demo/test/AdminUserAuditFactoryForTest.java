package org.demo.test;

import org.demo.bean.AdminUserAudit;

public class AdminUserAuditFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserAudit newAdminUserAudit() {

		Integer id = mockValues.nextInteger();

		AdminUserAudit adminUserAudit = new AdminUserAudit();
		adminUserAudit.setId(id);
		return adminUserAudit;
	}
	
}
