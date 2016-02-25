package org.demo.test;

import org.demo.bean.GlobalCurrencyRateDetail;

public class GlobalCurrencyRateDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrencyRateDetail newGlobalCurrencyRateDetail() {

		Integer id = mockValues.nextInteger();

		GlobalCurrencyRateDetail globalCurrencyRateDetail = new GlobalCurrencyRateDetail();
		globalCurrencyRateDetail.setId(id);
		return globalCurrencyRateDetail;
	}
	
}
