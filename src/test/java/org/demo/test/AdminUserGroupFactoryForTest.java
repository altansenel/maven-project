package org.demo.test;

import org.demo.bean.AdminUserGroup;

public class AdminUserGroupFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserGroup newAdminUserGroup() {

		Integer id = mockValues.nextInteger();

		AdminUserGroup adminUserGroup = new AdminUserGroup();
		adminUserGroup.setId(id);
		return adminUserGroup;
	}
	
}
