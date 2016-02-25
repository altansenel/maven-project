package org.demo.test;

import org.demo.bean.jpa.OrderTransEntity;

public class OrderTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransEntity newOrderTransEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransEntity orderTransEntity = new OrderTransEntity();
		orderTransEntity.setId(id);
		return orderTransEntity;
	}
	
}
