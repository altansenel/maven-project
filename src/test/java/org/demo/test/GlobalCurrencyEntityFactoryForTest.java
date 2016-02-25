package org.demo.test;

import org.demo.bean.jpa.GlobalCurrencyEntity;

public class GlobalCurrencyEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public GlobalCurrencyEntity newGlobalCurrencyEntity() {

		Integer id = mockValues.nextInteger();

		GlobalCurrencyEntity globalCurrencyEntity = new GlobalCurrencyEntity();
		globalCurrencyEntity.setId(id);
		return globalCurrencyEntity;
	}
	
}
