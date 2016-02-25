package org.demo.test;

import org.demo.bean.StockUnit;

public class StockUnitFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockUnit newStockUnit() {

		Integer id = mockValues.nextInteger();

		StockUnit stockUnit = new StockUnit();
		stockUnit.setId(id);
		return stockUnit;
	}
	
}
