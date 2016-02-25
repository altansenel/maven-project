package org.demo.test;

import org.demo.bean.Bank;

public class BankFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Bank newBank() {

		Integer id = mockValues.nextInteger();

		Bank bank = new Bank();
		bank.setId(id);
		return bank;
	}
	
}
