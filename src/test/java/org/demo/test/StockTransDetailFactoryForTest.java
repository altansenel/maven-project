package org.demo.test;

import org.demo.bean.StockTransDetail;

public class StockTransDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTransDetail newStockTransDetail() {

		Integer id = mockValues.nextInteger();

		StockTransDetail stockTransDetail = new StockTransDetail();
		stockTransDetail.setId(id);
		return stockTransDetail;
	}
	
}
