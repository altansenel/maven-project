package org.demo.test;

import org.demo.bean.TempContactAging;

public class TempContactAgingFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TempContactAging newTempContactAging() {

		Integer id = mockValues.nextInteger();

		TempContactAging tempContactAging = new TempContactAging();
		tempContactAging.setId(id);
		return tempContactAging;
	}
	
}
