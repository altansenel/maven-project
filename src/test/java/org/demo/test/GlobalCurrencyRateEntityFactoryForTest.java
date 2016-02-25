package org.demo.test;

import org.demo.bean.jpa.GlobalCurrencyRateEntity;

public class GlobalCurrencyRateEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrencyRateEntity newGlobalCurrencyRateEntity() {

		Integer id = mockValues.nextInteger();

		GlobalCurrencyRateEntity globalCurrencyRateEntity = new GlobalCurrencyRateEntity();
		globalCurrencyRateEntity.setId(id);
		return globalCurrencyRateEntity;
	}
	
}
