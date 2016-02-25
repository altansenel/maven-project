package org.demo.test;

import org.demo.bean.WaybillTransRelation;

public class WaybillTransRelationFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransRelation newWaybillTransRelation() {

		Integer id = mockValues.nextInteger();

		WaybillTransRelation waybillTransRelation = new WaybillTransRelation();
		waybillTransRelation.setId(id);
		return waybillTransRelation;
	}
	
}
