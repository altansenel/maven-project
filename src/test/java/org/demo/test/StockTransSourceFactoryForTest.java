package org.demo.test;

import org.demo.bean.StockTransSource;

public class StockTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransSource newStockTransSource() {

		Integer id = mockValues.nextInteger();

		StockTransSource stockTransSource = new StockTransSource();
		stockTransSource.setId(id);
		return stockTransSource;
	}
	
}
