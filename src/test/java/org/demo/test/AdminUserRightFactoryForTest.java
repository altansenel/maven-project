package org.demo.test;

import org.demo.bean.AdminUserRight;

public class AdminUserRightFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserRight newAdminUserRight() {

		Integer id = mockValues.nextInteger();

		AdminUserRight adminUserRight = new AdminUserRight();
		adminUserRight.setId(id);
		return adminUserRight;
	}
	
}
