package org.demo.test;

import org.demo.bean.jpa.WaybillTransRelationEntity;

public class WaybillTransRelationEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransRelationEntity newWaybillTransRelationEntity() {

		Integer id = mockValues.nextInteger();

		WaybillTransRelationEntity waybillTransRelationEntity = new WaybillTransRelationEntity();
		waybillTransRelationEntity.setId(id);
		return waybillTransRelationEntity;
	}
	
}
