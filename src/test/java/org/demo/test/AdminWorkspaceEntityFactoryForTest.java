package org.demo.test;

import org.demo.bean.jpa.AdminWorkspaceEntity;

public class AdminWorkspaceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminWorkspaceEntity newAdminWorkspaceEntity() {

		Integer id = mockValues.nextInteger();

		AdminWorkspaceEntity adminWorkspaceEntity = new AdminWorkspaceEntity();
		adminWorkspaceEntity.setId(id);
		return adminWorkspaceEntity;
	}
	
}
