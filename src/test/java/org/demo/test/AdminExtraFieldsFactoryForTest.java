package org.demo.test;

import org.demo.bean.AdminExtraFields;

public class AdminExtraFieldsFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminExtraFields newAdminExtraFields() {

		Integer id = mockValues.nextInteger();

		AdminExtraFields adminExtraFields = new AdminExtraFields();
		adminExtraFields.setId(id);
		return adminExtraFields;
	}
	
}
