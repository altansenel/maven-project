package org.demo.test;

import org.demo.bean.jpa.TempContactAgingEntity;

public class TempContactAgingEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TempContactAgingEntity newTempContactAgingEntity() {

		Integer id = mockValues.nextInteger();

		TempContactAgingEntity tempContactAgingEntity = new TempContactAgingEntity();
		tempContactAgingEntity.setId(id);
		return tempContactAgingEntity;
	}
	
}
