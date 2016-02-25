package org.demo.test;

import org.demo.bean.jpa.StockTransSourceEntity;

public class StockTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransSourceEntity newStockTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		StockTransSourceEntity stockTransSourceEntity = new StockTransSourceEntity();
		stockTransSourceEntity.setId(id);
		return stockTransSourceEntity;
	}
	
}
