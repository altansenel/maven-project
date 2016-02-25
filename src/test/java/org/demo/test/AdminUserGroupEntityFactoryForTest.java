package org.demo.test;

import org.demo.bean.jpa.AdminUserGroupEntity;

public class AdminUserGroupEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserGroupEntity newAdminUserGroupEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserGroupEntity adminUserGroupEntity = new AdminUserGroupEntity();
		adminUserGroupEntity.setId(id);
		return adminUserGroupEntity;
	}
	
}
