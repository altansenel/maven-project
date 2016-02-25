package org.demo.test;

import org.demo.bean.jpa.ContactExtraFieldsEntity;

public class ContactExtraFieldsEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactExtraFieldsEntity newContactExtraFieldsEntity() {

		Integer id = mockValues.nextInteger();

		ContactExtraFieldsEntity contactExtraFieldsEntity = new ContactExtraFieldsEntity();
		contactExtraFieldsEntity.setId(id);
		return contactExtraFieldsEntity;
	}
	
}
