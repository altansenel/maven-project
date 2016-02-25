package org.demo.test;

import org.demo.bean.Contact;

public class ContactFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Contact newContact() {

		Integer id = mockValues.nextInteger();

		Contact contact = new Contact();
		contact.setId(id);
		return contact;
	}
	
}
