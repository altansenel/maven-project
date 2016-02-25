package org.demo.test;

import org.demo.bean.OrderTransFactor;

public class OrderTransFactorFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransFactor newOrderTransFactor() {

		Integer id = mockValues.nextInteger();

		OrderTransFactor orderTransFactor = new OrderTransFactor();
		orderTransFactor.setId(id);
		return orderTransFactor;
	}
	
}
