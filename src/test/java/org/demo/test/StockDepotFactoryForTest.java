package org.demo.test;

import org.demo.bean.StockDepot;

public class StockDepotFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockDepot newStockDepot() {

		Integer id = mockValues.nextInteger();

		StockDepot stockDepot = new StockDepot();
		stockDepot.setId(id);
		return stockDepot;
	}
	
}
