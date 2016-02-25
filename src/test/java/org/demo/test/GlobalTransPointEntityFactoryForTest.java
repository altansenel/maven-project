package org.demo.test;

import org.demo.bean.jpa.GlobalTransPointEntity;

public class GlobalTransPointEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalTransPointEntity newGlobalTransPointEntity() {

		Integer id = mockValues.nextInteger();

		GlobalTransPointEntity globalTransPointEntity = new GlobalTransPointEntity();
		globalTransPointEntity.setId(id);
		return globalTransPointEntity;
	}
	
}
