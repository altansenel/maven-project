package org.demo.test;

import org.demo.bean.WaybillTransDetail;

public class WaybillTransDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public WaybillTransDetail newWaybillTransDetail() {

		Integer id = mockValues.nextInteger();

		WaybillTransDetail waybillTransDetail = new WaybillTransDetail();
		waybillTransDetail.setId(id);
		return waybillTransDetail;
	}
	
}
