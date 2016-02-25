package org.demo.test;

import org.demo.bean.jpa.ContactTransEntity;

public class ContactTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactTransEntity newContactTransEntity() {

		Integer id = mockValues.nextInteger();

		ContactTransEntity contactTransEntity = new ContactTransEntity();
		contactTransEntity.setId(id);
		return contactTransEntity;
	}
	
}
