package org.demo.test;

import org.demo.bean.jpa.OrderTransStatusEntity;

public class OrderTransStatusEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransStatusEntity newOrderTransStatusEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransStatusEntity orderTransStatusEntity = new OrderTransStatusEntity();
		orderTransStatusEntity.setId(id);
		return orderTransStatusEntity;
	}
	
}
