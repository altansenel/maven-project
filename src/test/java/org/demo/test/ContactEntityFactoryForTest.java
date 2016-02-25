package org.demo.test;

import org.demo.bean.jpa.ContactEntity;

public class ContactEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactEntity newContactEntity() {

		Integer id = mockValues.nextInteger();

		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setId(id);
		return contactEntity;
	}
	
}
