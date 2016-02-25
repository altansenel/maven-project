package org.demo.test;

import org.demo.bean.StockCostingDetail;

public class StockCostingDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockCostingDetail newStockCostingDetail() {

		Integer id = mockValues.nextInteger();

		StockCostingDetail stockCostingDetail = new StockCostingDetail();
		stockCostingDetail.setId(id);
		return stockCostingDetail;
	}
	
}
