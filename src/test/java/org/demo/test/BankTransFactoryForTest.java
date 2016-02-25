package org.demo.test;

import org.demo.bean.BankTrans;

public class BankTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public BankTrans newBankTrans() {

		Integer id = mockValues.nextInteger();

		BankTrans bankTrans = new BankTrans();
		bankTrans.setId(id);
		return bankTrans;
	}
	
}
