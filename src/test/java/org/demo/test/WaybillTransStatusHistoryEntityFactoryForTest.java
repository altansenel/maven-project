package org.demo.test;

import org.demo.bean.jpa.WaybillTransStatusHistoryEntity;

public class WaybillTransStatusHistoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransStatusHistoryEntity newWaybillTransStatusHistoryEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntity = new WaybillTransStatusHistoryEntity();
		waybillTransStatusHistoryEntity.setId(id);
		return waybillTransStatusHistoryEntity;
	}
	
}
