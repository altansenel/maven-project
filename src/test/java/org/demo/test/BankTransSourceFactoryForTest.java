package org.demo.test;

import org.demo.bean.BankTransSource;

public class BankTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankTransSource newBankTransSource() {

		Integer id = mockValues.nextInteger();

		BankTransSource bankTransSource = new BankTransSource();
		bankTransSource.setId(id);
		return bankTransSource;
	}
	
}
