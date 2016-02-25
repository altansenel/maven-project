package org.demo.test;

import org.demo.bean.GlobalProfile;

public class GlobalProfileFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalProfile newGlobalProfile() {

		Integer id = mockValues.nextInteger();

		GlobalProfile globalProfile = new GlobalProfile();
		globalProfile.setId(id);
		return globalProfile;
	}
	
}
