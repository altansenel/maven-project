package org.demo.test;

import org.demo.bean.StockTransCurrency;

public class StockTransCurrencyFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransCurrency newStockTransCurrency() {

		Integer id = mockValues.nextInteger();

		StockTransCurrency stockTransCurrency = new StockTransCurrency();
		stockTransCurrency.setId(id);
		return stockTransCurrency;
	}
	
}
