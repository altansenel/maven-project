package org.demo.test;

import org.demo.bean.SafeTrans;

public class SafeTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeTrans newSafeTrans() {

		Integer id = mockValues.nextInteger();

		SafeTrans safeTrans = new SafeTrans();
		safeTrans.setId(id);
		return safeTrans;
	}
	
}
