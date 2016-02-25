package org.demo.test;

import org.demo.bean.jpa.StockCostingDetailEntity;

public class StockCostingDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostingDetailEntity newStockCostingDetailEntity() {

		Integer id = mockValues.nextInteger();

		StockCostingDetailEntity stockCostingDetailEntity = new StockCostingDetailEntity();
		stockCostingDetailEntity.setId(id);
		return stockCostingDetailEntity;
	}
	
}
