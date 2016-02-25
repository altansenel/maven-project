package org.demo.test;

import org.demo.bean.OrderTransSource;

public class OrderTransSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransSource newOrderTransSource() {

		Integer id = mockValues.nextInteger();

		OrderTransSource orderTransSource = new OrderTransSource();
		orderTransSource.setId(id);
		return orderTransSource;
	}
	
}
