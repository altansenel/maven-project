package org.demo.test;

import org.demo.bean.jpa.StockExtraFieldsEntity;

public class StockExtraFieldsEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockExtraFieldsEntity newStockExtraFieldsEntity() {

		Integer id = mockValues.nextInteger();

		StockExtraFieldsEntity stockExtraFieldsEntity = new StockExtraFieldsEntity();
		stockExtraFieldsEntity.setId(id);
		return stockExtraFieldsEntity;
	}
	
}
