package org.demo.test;

import org.demo.bean.StockCosting;

public class StockCostingFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCosting newStockCosting() {

		Integer id = mockValues.nextInteger();

		StockCosting stockCosting = new StockCosting();
		stockCosting.setId(id);
		return stockCosting;
	}
	
}
