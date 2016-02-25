package org.demo.test;

import org.demo.bean.StockExtraFields;

public class StockExtraFieldsFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockExtraFields newStockExtraFields() {

		Integer id = mockValues.nextInteger();

		StockExtraFields stockExtraFields = new StockExtraFields();
		stockExtraFields.setId(id);
		return stockExtraFields;
	}
	
}
