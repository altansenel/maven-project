package org.demo.test;

import org.demo.bean.GlobalCurrencyRate;

public class GlobalCurrencyRateFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrencyRate newGlobalCurrencyRate() {

		Integer id = mockValues.nextInteger();

		GlobalCurrencyRate globalCurrencyRate = new GlobalCurrencyRate();
		globalCurrencyRate.setId(id);
		return globalCurrencyRate;
	}
	
}
