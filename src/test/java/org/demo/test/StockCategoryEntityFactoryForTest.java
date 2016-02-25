package org.demo.test;

import org.demo.bean.jpa.StockCategoryEntity;

public class StockCategoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCategoryEntity newStockCategoryEntity() {

		Integer id = mockValues.nextInteger();

		StockCategoryEntity stockCategoryEntity = new StockCategoryEntity();
		stockCategoryEntity.setId(id);
		return stockCategoryEntity;
	}
	
}
