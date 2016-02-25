package org.demo.test;

import org.demo.bean.jpa.StockPriceListEntity;

public class StockPriceListEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceListEntity newStockPriceListEntity() {

		Integer id = mockValues.nextInteger();

		StockPriceListEntity stockPriceListEntity = new StockPriceListEntity();
		stockPriceListEntity.setId(id);
		return stockPriceListEntity;
	}
	
}
