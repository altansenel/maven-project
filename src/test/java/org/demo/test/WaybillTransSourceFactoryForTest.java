package org.demo.test;

import org.demo.bean.WaybillTransSource;

public class WaybillTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransSource newWaybillTransSource() {

		Integer id = mockValues.nextInteger();

		WaybillTransSource waybillTransSource = new WaybillTransSource();
		waybillTransSource.setId(id);
		return waybillTransSource;
	}
	
}
