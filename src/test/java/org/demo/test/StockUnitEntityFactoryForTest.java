package org.demo.test;

import org.demo.bean.jpa.StockUnitEntity;

public class StockUnitEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockUnitEntity newStockUnitEntity() {

		Integer id = mockValues.nextInteger();

		StockUnitEntity stockUnitEntity = new StockUnitEntity();
		stockUnitEntity.setId(id);
		return stockUnitEntity;
	}
	
}
