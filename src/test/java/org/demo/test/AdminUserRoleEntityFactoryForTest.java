package org.demo.test;

import org.demo.bean.jpa.AdminUserRoleEntity;

public class AdminUserRoleEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserRoleEntity newAdminUserRoleEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserRoleEntity adminUserRoleEntity = new AdminUserRoleEntity();
		adminUserRoleEntity.setId(id);
		return adminUserRoleEntity;
	}
	
}
