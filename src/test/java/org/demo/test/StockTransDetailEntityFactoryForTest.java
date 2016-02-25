package org.demo.test;

import org.demo.bean.jpa.StockTransDetailEntity;

public class StockTransDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransDetailEntity newStockTransDetailEntity() {

		Integer id = mockValues.nextInteger();

		StockTransDetailEntity stockTransDetailEntity = new StockTransDetailEntity();
		stockTransDetailEntity.setId(id);
		return stockTransDetailEntity;
	}
	
}
