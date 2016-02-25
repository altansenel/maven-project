package org.demo.test;

import org.demo.bean.ContactExtraFields;

public class ContactExtraFieldsFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactExtraFields newContactExtraFields() {

		Integer id = mockValues.nextInteger();

		ContactExtraFields contactExtraFields = new ContactExtraFields();
		contactExtraFields.setId(id);
		return contactExtraFields;
	}
	
}
