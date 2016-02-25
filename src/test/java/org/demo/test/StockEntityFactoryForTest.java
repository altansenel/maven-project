package org.demo.test;

import org.demo.bean.jpa.StockEntity;

public class StockEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockEntity newStockEntity() {

		Integer id = mockValues.nextInteger();

		StockEntity stockEntity = new StockEntity();
		stockEntity.setId(id);
		return stockEntity;
	}
	
}
