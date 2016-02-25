package org.demo.test;

import org.demo.bean.ContactCategory;

public class ContactCategoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ContactCategory newContactCategory() {

		Integer id = mockValues.nextInteger();

		ContactCategory contactCategory = new ContactCategory();
		contactCategory.setId(id);
		return contactCategory;
	}
	
}
