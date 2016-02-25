package org.demo.test;

import org.demo.bean.StockBarcode;

public class StockBarcodeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockBarcode newStockBarcode() {

		Integer id = mockValues.nextInteger();

		StockBarcode stockBarcode = new StockBarcode();
		stockBarcode.setId(id);
		return stockBarcode;
	}
	
}
