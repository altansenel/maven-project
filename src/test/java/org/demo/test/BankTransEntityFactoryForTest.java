package org.demo.test;

import org.demo.bean.jpa.BankTransEntity;

public class BankTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankTransEntity newBankTransEntity() {

		Integer id = mockValues.nextInteger();

		BankTransEntity bankTransEntity = new BankTransEntity();
		bankTransEntity.setId(id);
		return bankTransEntity;
	}
	
}
