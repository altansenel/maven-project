package org.demo.test;

import org.demo.bean.jpa.SaleSellerEntity;

public class SaleSellerEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SaleSellerEntity newSaleSellerEntity() {

		Integer id = mockValues.nextInteger();

		SaleSellerEntity saleSellerEntity = new SaleSellerEntity();
		saleSellerEntity.setId(id);
		return saleSellerEntity;
	}
	
}
