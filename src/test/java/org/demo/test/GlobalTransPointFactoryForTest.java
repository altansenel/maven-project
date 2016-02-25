package org.demo.test;

import org.demo.bean.GlobalTransPoint;

public class GlobalTransPointFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalTransPoint newGlobalTransPoint() {

		Integer id = mockValues.nextInteger();

		GlobalTransPoint globalTransPoint = new GlobalTransPoint();
		globalTransPoint.setId(id);
		return globalTransPoint;
	}
	
}
