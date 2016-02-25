package org.demo.test;

import org.demo.bean.AdminWorkspace;

public class AdminWorkspaceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminWorkspace newAdminWorkspace() {

		Integer id = mockValues.nextInteger();

		AdminWorkspace adminWorkspace = new AdminWorkspace();
		adminWorkspace.setId(id);
		return adminWorkspace;
	}
	
}
