package org.demo.test;

import org.demo.bean.StockCostFactor;

public class StockCostFactorFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostFactor newStockCostFactor() {

		Integer id = mockValues.nextInteger();

		StockCostFactor stockCostFactor = new StockCostFactor();
		stockCostFactor.setId(id);
		return stockCostFactor;
	}
	
}
