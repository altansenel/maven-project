package org.demo.test;

import org.demo.bean.jpa.BankTransSourceEntity;

public class BankTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankTransSourceEntity newBankTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		BankTransSourceEntity bankTransSourceEntity = new BankTransSourceEntity();
		bankTransSourceEntity.setId(id);
		return bankTransSourceEntity;
	}
	
}
