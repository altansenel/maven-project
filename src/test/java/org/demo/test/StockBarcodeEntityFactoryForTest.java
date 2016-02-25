package org.demo.test;

import org.demo.bean.jpa.StockBarcodeEntity;

public class StockBarcodeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public StockBarcodeEntity newStockBarcodeEntity() {

		Integer id = mockValues.nextInteger();

		StockBarcodeEntity stockBarcodeEntity = new StockBarcodeEntity();
		stockBarcodeEntity.setId(id);
		return stockBarcodeEntity;
	}
	
}
