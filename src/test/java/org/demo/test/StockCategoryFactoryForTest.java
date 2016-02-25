package org.demo.test;

import org.demo.bean.StockCategory;

public class StockCategoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCategory newStockCategory() {

		Integer id = mockValues.nextInteger();

		StockCategory stockCategory = new StockCategory();
		stockCategory.setId(id);
		return stockCategory;
	}
	
}
