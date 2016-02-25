package org.demo.test;

import org.demo.bean.SafeExpense;

public class SafeExpenseFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SafeExpense newSafeExpense() {

		Integer id = mockValues.nextInteger();

		SafeExpense safeExpense = new SafeExpense();
		safeExpense.setId(id);
		return safeExpense;
	}
	
}
