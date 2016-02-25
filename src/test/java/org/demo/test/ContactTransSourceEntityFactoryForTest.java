package org.demo.test;

import org.demo.bean.jpa.ContactTransSourceEntity;

public class ContactTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactTransSourceEntity newContactTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		ContactTransSourceEntity contactTransSourceEntity = new ContactTransSourceEntity();
		contactTransSourceEntity.setId(id);
		return contactTransSourceEntity;
	}
	
}
