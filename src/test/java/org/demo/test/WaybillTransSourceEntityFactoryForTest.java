package org.demo.test;

import org.demo.bean.jpa.WaybillTransSourceEntity;

public class WaybillTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransSourceEntity newWaybillTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransSourceEntity waybillTransSourceEntity = new WaybillTransSourceEntity();
		waybillTransSourceEntity.setId(id);
		return waybillTransSourceEntity;
	}
	
}
