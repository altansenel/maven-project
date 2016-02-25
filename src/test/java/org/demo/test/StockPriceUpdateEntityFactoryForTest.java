package org.demo.test;

import org.demo.bean.jpa.StockPriceUpdateEntity;

public class StockPriceUpdateEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceUpdateEntity newStockPriceUpdateEntity() {

		Integer id = mockValues.nextInteger();

		StockPriceUpdateEntity stockPriceUpdateEntity = new StockPriceUpdateEntity();
		stockPriceUpdateEntity.setId(id);
		return stockPriceUpdateEntity;
	}
	
}
