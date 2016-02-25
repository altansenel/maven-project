package org.demo.test;

import org.demo.bean.jpa.AdminUserGivenRoleEntity;

public class AdminUserGivenRoleEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminUserGivenRoleEntity newAdminUserGivenRoleEntity() {

		Integer id = mockValues.nextInteger();

		AdminUserGivenRoleEntity adminUserGivenRoleEntity = new AdminUserGivenRoleEntity();
		adminUserGivenRoleEntity.setId(id);
		return adminUserGivenRoleEntity;
	}
	
}
