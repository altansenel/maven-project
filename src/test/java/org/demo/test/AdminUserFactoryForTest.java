package org.demo.test;

import org.demo.bean.AdminUser;

public class AdminUserFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUser newAdminUser() {

		Integer id = mockValues.nextInteger();

		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		return adminUser;
	}
	
}
