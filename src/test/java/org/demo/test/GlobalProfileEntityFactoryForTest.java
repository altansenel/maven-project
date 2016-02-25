package org.demo.test;

import org.demo.bean.jpa.GlobalProfileEntity;

public class GlobalProfileEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalProfileEntity newGlobalProfileEntity() {

		Integer id = mockValues.nextInteger();

		GlobalProfileEntity globalProfileEntity = new GlobalProfileEntity();
		globalProfileEntity.setId(id);
		return globalProfileEntity;
	}
	
}
