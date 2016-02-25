package org.demo.test;

import org.demo.bean.ContactTrans;

public class ContactTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactTrans newContactTrans() {

		Integer id = mockValues.nextInteger();

		ContactTrans contactTrans = new ContactTrans();
		contactTrans.setId(id);
		return contactTrans;
	}
	
}
