package org.demo.test;

import org.demo.bean.jpa.StockTransEntity;

public class StockTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransEntity newStockTransEntity() {

		Integer id = mockValues.nextInteger();

		StockTransEntity stockTransEntity = new StockTransEntity();
		stockTransEntity.setId(id);
		return stockTransEntity;
	}
	
}
