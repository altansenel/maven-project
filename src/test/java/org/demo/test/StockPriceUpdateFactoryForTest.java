package org.demo.test;

import org.demo.bean.StockPriceUpdate;

public class StockPriceUpdateFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceUpdate newStockPriceUpdate() {

		Integer id = mockValues.nextInteger();

		StockPriceUpdate stockPriceUpdate = new StockPriceUpdate();
		stockPriceUpdate.setId(id);
		return stockPriceUpdate;
	}
	
}
