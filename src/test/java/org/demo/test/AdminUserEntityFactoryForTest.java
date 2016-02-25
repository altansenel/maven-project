package org.demo.test;

import org.demo.bean.jpa.AdminUserEntity;

public class AdminUserEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserEntity newAdminUserEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserEntity adminUserEntity = new AdminUserEntity();
		adminUserEntity.setId(id);
		return adminUserEntity;
	}
	
}
