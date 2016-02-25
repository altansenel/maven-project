package org.demo.test;

import org.demo.bean.SaleSeller;

public class SaleSellerFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SaleSeller newSaleSeller() {

		Integer id = mockValues.nextInteger();

		SaleSeller saleSeller = new SaleSeller();
		saleSeller.setId(id);
		return saleSeller;
	}
	
}
