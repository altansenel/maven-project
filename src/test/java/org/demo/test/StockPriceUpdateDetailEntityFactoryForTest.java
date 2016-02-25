package org.demo.test;

import org.demo.bean.jpa.StockPriceUpdateDetailEntity;

public class StockPriceUpdateDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceUpdateDetailEntity newStockPriceUpdateDetailEntity() {

		Integer id = mockValues.nextInteger();

		StockPriceUpdateDetailEntity stockPriceUpdateDetailEntity = new StockPriceUpdateDetailEntity();
		stockPriceUpdateDetailEntity.setId(id);
		return stockPriceUpdateDetailEntity;
	}
	
}
