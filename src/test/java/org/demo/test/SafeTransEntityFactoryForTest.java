package org.demo.test;

import org.demo.bean.jpa.SafeTransEntity;

public class SafeTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeTransEntity newSafeTransEntity() {

		Integer id = mockValues.nextInteger();

		SafeTransEntity safeTransEntity = new SafeTransEntity();
		safeTransEntity.setId(id);
		return safeTransEntity;
	}
	
}
