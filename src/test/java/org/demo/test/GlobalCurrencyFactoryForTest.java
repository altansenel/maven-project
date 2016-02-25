package org.demo.test;

import org.demo.bean.GlobalCurrency;

public class GlobalCurrencyFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrency newGlobalCurrency() {

		Integer id = mockValues.nextInteger();

		GlobalCurrency globalCurrency = new GlobalCurrency();
		globalCurrency.setId(id);
		return globalCurrency;
	}
	
}
