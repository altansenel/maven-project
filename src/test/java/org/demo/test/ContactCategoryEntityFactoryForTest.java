package org.demo.test;

import org.demo.bean.jpa.ContactCategoryEntity;

public class ContactCategoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactCategoryEntity newContactCategoryEntity() {

		Integer id = mockValues.nextInteger();

		ContactCategoryEntity contactCategoryEntity = new ContactCategoryEntity();
		contactCategoryEntity.setId(id);
		return contactCategoryEntity;
	}
	
}
