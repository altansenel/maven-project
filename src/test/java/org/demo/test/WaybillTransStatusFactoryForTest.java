package org.demo.test;

import org.demo.bean.WaybillTransStatus;

public class WaybillTransStatusFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransStatus newWaybillTransStatus() {

		Integer id = mockValues.nextInteger();

		WaybillTransStatus waybillTransStatus = new WaybillTransStatus();
		waybillTransStatus.setId(id);
		return waybillTransStatus;
	}
	
}
