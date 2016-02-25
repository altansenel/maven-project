package org.demo.test;

import org.demo.bean.jpa.StockDepotEntity;

public class StockDepotEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockDepotEntity newStockDepotEntity() {

		Integer id = mockValues.nextInteger();

		StockDepotEntity stockDepotEntity = new StockDepotEntity();
		stockDepotEntity.setId(id);
		return stockDepotEntity;
	}
	
}
