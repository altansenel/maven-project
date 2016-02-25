package org.demo.test;

import org.demo.bean.StockTrans;

public class StockTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockTrans newStockTrans() {

		Integer id = mockValues.nextInteger();

		StockTrans stockTrans = new StockTrans();
		stockTrans.setId(id);
		return stockTrans;
	}
	
}
