package org.demo.test;

import org.demo.bean.AdminUserGivenRole;

public class AdminUserGivenRoleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserGivenRole newAdminUserGivenRole() {

		Integer id = mockValues.nextInteger();

		AdminUserGivenRole adminUserGivenRole = new AdminUserGivenRole();
		adminUserGivenRole.setId(id);
		return adminUserGivenRole;
	}
	
}
