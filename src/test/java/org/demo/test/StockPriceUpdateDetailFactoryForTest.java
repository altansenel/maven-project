package org.demo.test;

import org.demo.bean.StockPriceUpdateDetail;

public class StockPriceUpdateDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockPriceUpdateDetail newStockPriceUpdateDetail() {

		Integer id = mockValues.nextInteger();

		StockPriceUpdateDetail stockPriceUpdateDetail = new StockPriceUpdateDetail();
		stockPriceUpdateDetail.setId(id);
		return stockPriceUpdateDetail;
	}
	
}
