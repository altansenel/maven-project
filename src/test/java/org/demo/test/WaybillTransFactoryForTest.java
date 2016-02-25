package org.demo.test;

import org.demo.bean.WaybillTrans;

public class WaybillTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTrans newWaybillTrans() {

		Integer id = mockValues.nextInteger();

		WaybillTrans waybillTrans = new WaybillTrans();
		waybillTrans.setId(id);
		return waybillTrans;
	}
	
}
