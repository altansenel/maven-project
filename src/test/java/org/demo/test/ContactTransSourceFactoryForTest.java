package org.demo.test;

import org.demo.bean.ContactTransSource;

public class ContactTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactTransSource newContactTransSource() {

		Integer id = mockValues.nextInteger();

		ContactTransSource contactTransSource = new ContactTransSource();
		contactTransSource.setId(id);
		return contactTransSource;
	}
	
}
