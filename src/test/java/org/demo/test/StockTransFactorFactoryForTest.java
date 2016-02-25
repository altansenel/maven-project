package org.demo.test;

import org.demo.bean.StockTransFactor;

public class StockTransFactorFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransFactor newStockTransFactor() {

		Integer id = mockValues.nextInteger();

		StockTransFactor stockTransFactor = new StockTransFactor();
		stockTransFactor.setId(id);
		return stockTransFactor;
	}
	
}
