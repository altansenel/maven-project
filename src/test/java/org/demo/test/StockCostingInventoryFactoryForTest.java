package org.demo.test;

import org.demo.bean.StockCostingInventory;

public class StockCostingInventoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostingInventory newStockCostingInventory() {

		Integer id = mockValues.nextInteger();

		StockCostingInventory stockCostingInventory = new StockCostingInventory();
		stockCostingInventory.setId(id);
		return stockCostingInventory;
	}
	
}
