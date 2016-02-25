package org.demo.test;

import org.demo.bean.SafeTransSource;

public class SafeTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeTransSource newSafeTransSource() {

		Integer id = mockValues.nextInteger();

		SafeTransSource safeTransSource = new SafeTransSource();
		safeTransSource.setId(id);
		return safeTransSource;
	}
	
}
