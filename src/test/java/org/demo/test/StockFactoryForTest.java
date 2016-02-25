package org.demo.test;

import org.demo.bean.Stock;

public class StockFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Stock newStock() {

		Integer id = mockValues.nextInteger();

		Stock stock = new Stock();
		stock.setId(id);
		return stock;
	}
	
}
