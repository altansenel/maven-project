package org.demo.test;

import org.demo.bean.jpa.StockCostingInventoryEntity;

public class StockCostingInventoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostingInventoryEntity newStockCostingInventoryEntity() {

		Integer id = mockValues.nextInteger();

		StockCostingInventoryEntity stockCostingInventoryEntity = new StockCostingInventoryEntity();
		stockCostingInventoryEntity.setId(id);
		return stockCostingInventoryEntity;
	}
	
}
