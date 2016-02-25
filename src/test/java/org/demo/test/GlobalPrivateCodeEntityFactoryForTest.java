package org.demo.test;

import org.demo.bean.jpa.GlobalPrivateCodeEntity;

public class GlobalPrivateCodeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalPrivateCodeEntity newGlobalPrivateCodeEntity() {

		Integer id = mockValues.nextInteger();

		GlobalPrivateCodeEntity globalPrivateCodeEntity = new GlobalPrivateCodeEntity();
		globalPrivateCodeEntity.setId(id);
		return globalPrivateCodeEntity;
	}
	
}
