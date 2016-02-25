package org.demo.test;

import org.demo.bean.jpa.StockTransTaxEntity;

public class StockTransTaxEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransTaxEntity newStockTransTaxEntity() {

		Integer id = mockValues.nextInteger();

		StockTransTaxEntity stockTransTaxEntity = new StockTransTaxEntity();
		stockTransTaxEntity.setId(id);
		return stockTransTaxEntity;
	}
	
}
