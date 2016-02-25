package org.demo.test;

import org.demo.bean.jpa.StockTransFactorEntity;

public class StockTransFactorEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransFactorEntity newStockTransFactorEntity() {

		Integer id = mockValues.nextInteger();

		StockTransFactorEntity stockTransFactorEntity = new StockTransFactorEntity();
		stockTransFactorEntity.setId(id);
		return stockTransFactorEntity;
	}
	
}
