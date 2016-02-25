package org.demo.test;

import org.demo.bean.AdminUserRole;

public class AdminUserRoleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserRole newAdminUserRole() {

		Integer id = mockValues.nextInteger();

		AdminUserRole adminUserRole = new AdminUserRole();
		adminUserRole.setId(id);
		return adminUserRole;
	}
	
}
