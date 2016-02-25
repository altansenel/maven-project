package org.demo.test;

import org.demo.bean.Safe;

public class SafeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Safe newSafe() {

		Integer id = mockValues.nextInteger();

		Safe safe = new Safe();
		safe.setId(id);
		return safe;
	}
	
}
