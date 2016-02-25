package org.demo.test;

import org.demo.bean.StockPriceList;

public class StockPriceListFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceList newStockPriceList() {

		Integer id = mockValues.nextInteger();

		StockPriceList stockPriceList = new StockPriceList();
		stockPriceList.setId(id);
		return stockPriceList;
	}
	
}
