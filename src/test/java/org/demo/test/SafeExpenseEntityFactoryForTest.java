package org.demo.test;

import org.demo.bean.jpa.SafeExpenseEntity;

public class SafeExpenseEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeExpenseEntity newSafeExpenseEntity() {

		Integer id = mockValues.nextInteger();

		SafeExpenseEntity safeExpenseEntity = new SafeExpenseEntity();
		safeExpenseEntity.setId(id);
		return safeExpenseEntity;
	}
	
}
