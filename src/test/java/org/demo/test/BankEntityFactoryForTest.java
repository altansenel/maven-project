package org.demo.test;

import org.demo.bean.jpa.BankEntity;

public class BankEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankEntity newBankEntity() {

		Integer id = mockValues.nextInteger();

		BankEntity bankEntity = new BankEntity();
		bankEntity.setId(id);
		return bankEntity;
	}
	
}
