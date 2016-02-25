package org.demo.test;

import org.demo.bean.jpa.AdminSettingEntity;

public class AdminSettingEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminSettingEntity newAdminSettingEntity() {

		Integer id = mockValues.nextInteger();

		AdminSettingEntity adminSettingEntity = new AdminSettingEntity();
		adminSettingEntity.setId(id);
		return adminSettingEntity;
	}
	
}
