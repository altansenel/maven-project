package org.demo.test;

import org.demo.bean.OrderTransStatus;

public class OrderTransStatusFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransStatus newOrderTransStatus() {

		Integer id = mockValues.nextInteger();

		OrderTransStatus orderTransStatus = new OrderTransStatus();
		orderTransStatus.setId(id);
		return orderTransStatus;
	}
	
}
