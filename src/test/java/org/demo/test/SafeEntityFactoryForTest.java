package org.demo.test;

import org.demo.bean.jpa.SafeEntity;

public class SafeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeEntity newSafeEntity() {

		Integer id = mockValues.nextInteger();

		SafeEntity safeEntity = new SafeEntity();
		safeEntity.setId(id);
		return safeEntity;
	}
	
}
