package org.demo.test;

import org.demo.bean.jpa.WaybillTransEntity;

public class WaybillTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransEntity newWaybillTransEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransEntity waybillTransEntity = new WaybillTransEntity();
		waybillTransEntity.setId(id);
		return waybillTransEntity;
	}
	
}
