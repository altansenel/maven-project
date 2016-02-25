package org.demo.test;

import org.demo.bean.jpa.StockCostFactorEntity;

public class StockCostFactorEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostFactorEntity newStockCostFactorEntity() {

		Integer id = mockValues.nextInteger();

		StockCostFactorEntity stockCostFactorEntity = new StockCostFactorEntity();
		stockCostFactorEntity.setId(id);
		return stockCostFactorEntity;
	}
	
}
