package org.demo.test;

import org.demo.bean.jpa.StockTransCurrencyEntity;

public class StockTransCurrencyEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransCurrencyEntity newStockTransCurrencyEntity() {

		Integer id = mockValues.nextInteger();

		StockTransCurrencyEntity stockTransCurrencyEntity = new StockTransCurrencyEntity();
		stockTransCurrencyEntity.setId(id);
		return stockTransCurrencyEntity;
	}
	
}
