package org.demo.test;

import org.demo.bean.jpa.BankExpenseEntity;

public class BankExpenseEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankExpenseEntity newBankExpenseEntity() {

		Integer id = mockValues.nextInteger();

		BankExpenseEntity bankExpenseEntity = new BankExpenseEntity();
		bankExpenseEntity.setId(id);
		return bankExpenseEntity;
	}
	
}
