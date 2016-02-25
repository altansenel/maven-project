package org.demo.test;

import org.demo.bean.WaybillTransFactor;

public class WaybillTransFactorFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransFactor newWaybillTransFactor() {

		Integer id = mockValues.nextInteger();

		WaybillTransFactor waybillTransFactor = new WaybillTransFactor();
		waybillTransFactor.setId(id);
		return waybillTransFactor;
	}
	
}
