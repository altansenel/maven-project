package org.demo.test;

import org.demo.bean.jpa.SafeTransSourceEntity;

public class SafeTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeTransSourceEntity newSafeTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		SafeTransSourceEntity safeTransSourceEntity = new SafeTransSourceEntity();
		safeTransSourceEntity.setId(id);
		return safeTransSourceEntity;
	}
	
}
