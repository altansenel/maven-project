package org.demo.test;

import org.demo.bean.jpa.WaybillTransStatusEntity;

public class WaybillTransStatusEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransStatusEntity newWaybillTransStatusEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransStatusEntity waybillTransStatusEntity = new WaybillTransStatusEntity();
		waybillTransStatusEntity.setId(id);
		return waybillTransStatusEntity;
	}
	
}
