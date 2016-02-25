package org.demo.test;

import org.demo.bean.StockTransTax;

public class StockTransTaxFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransTax newStockTransTax() {

		Integer id = mockValues.nextInteger();

		StockTransTax stockTransTax = new StockTransTax();
		stockTransTax.setId(id);
		return stockTransTax;
	}
	
}
