package org.demo.test;

import org.demo.bean.GlobalPrivateCode;

public class GlobalPrivateCodeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalPrivateCode newGlobalPrivateCode() {

		Integer id = mockValues.nextInteger();

		GlobalPrivateCode globalPrivateCode = new GlobalPrivateCode();
		globalPrivateCode.setId(id);
		return globalPrivateCode;
	}
	
}
