package org.demo.test;

import org.demo.bean.WaybillTransStatusHistory;

public class WaybillTransStatusHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransStatusHistory newWaybillTransStatusHistory() {

		Integer id = mockValues.nextInteger();

		WaybillTransStatusHistory waybillTransStatusHistory = new WaybillTransStatusHistory();
		waybillTransStatusHistory.setId(id);
		return waybillTransStatusHistory;
	}
	
}
