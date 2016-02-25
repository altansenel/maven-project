package org.demo.test;

import org.demo.bean.jpa.AdminUserRightEntity;

public class AdminUserRightEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserRightEntity newAdminUserRightEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserRightEntity adminUserRightEntity = new AdminUserRightEntity();
		adminUserRightEntity.setId(id);
		return adminUserRightEntity;
	}
	
}
