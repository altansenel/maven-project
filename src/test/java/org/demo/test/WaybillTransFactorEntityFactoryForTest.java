package org.demo.test;

import org.demo.bean.jpa.WaybillTransFactorEntity;

public class WaybillTransFactorEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransFactorEntity newWaybillTransFactorEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransFactorEntity waybillTransFactorEntity = new WaybillTransFactorEntity();
		waybillTransFactorEntity.setId(id);
		return waybillTransFactorEntity;
	}
	
}
