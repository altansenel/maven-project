package org.demo.test;

import org.demo.bean.BankExpense;

public class BankExpenseFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankExpense newBankExpense() {

		Integer id = mockValues.nextInteger();

		BankExpense bankExpense = new BankExpense();
		bankExpense.setId(id);
		return bankExpense;
	}
	
}
