package org.demo.test;

import org.demo.bean.jpa.OrderTransSourceEntity;

public class OrderTransSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransSourceEntity newOrderTransSourceEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransSourceEntity orderTransSourceEntity = new OrderTransSourceEntity();
		orderTransSourceEntity.setId(id);
		return orderTransSourceEntity;
	}
	
}
