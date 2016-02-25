package org.demo.test;

import org.demo.bean.jpa.StockCostingEntity;

public class StockCostingEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostingEntity newStockCostingEntity() {

		Integer id = mockValues.nextInteger();

		StockCostingEntity stockCostingEntity = new StockCostingEntity();
		stockCostingEntity.setId(id);
		return stockCostingEntity;
	}
	
}
