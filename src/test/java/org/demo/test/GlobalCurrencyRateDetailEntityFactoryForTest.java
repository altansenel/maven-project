package org.demo.test;

import org.demo.bean.jpa.GlobalCurrencyRateDetailEntity;

public class GlobalCurrencyRateDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrencyRateDetailEntity newGlobalCurrencyRateDetailEntity() {

		Integer id = mockValues.nextInteger();

		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntity = new GlobalCurrencyRateDetailEntity();
		globalCurrencyRateDetailEntity.setId(id);
		return globalCurrencyRateDetailEntity;
	}
	
}
