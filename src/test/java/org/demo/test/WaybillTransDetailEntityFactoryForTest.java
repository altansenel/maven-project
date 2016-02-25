package org.demo.test;

import org.demo.bean.jpa.WaybillTransDetailEntity;

public class WaybillTransDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransDetailEntity newWaybillTransDetailEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransDetailEntity waybillTransDetailEntity = new WaybillTransDetailEntity();
		waybillTransDetailEntity.setId(id);
		return waybillTransDetailEntity;
	}
	
}
