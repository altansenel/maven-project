package org.demo.test;

import org.demo.bean.jpa.AdminExtraFieldsEntity;

public class AdminExtraFieldsEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminExtraFieldsEntity newAdminExtraFieldsEntity() {

		Integer id = mockValues.nextInteger();

		AdminExtraFieldsEntity adminExtraFieldsEntity = new AdminExtraFieldsEntity();
		adminExtraFieldsEntity.setId(id);
		return adminExtraFieldsEntity;
	}
	
}
