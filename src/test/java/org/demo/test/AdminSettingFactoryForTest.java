package org.demo.test;

import org.demo.bean.AdminSetting;

public class AdminSettingFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AdminSetting newAdminSetting() {

		Integer id = mockValues.nextInteger();

		AdminSetting adminSetting = new AdminSetting();
		adminSetting.setId(id);
		return adminSetting;
	}
	
}
