package org.demo.test;

import org.demo.bean.jpa.OrderTransFactorEntity;

public class OrderTransFactorEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransFactorEntity newOrderTransFactorEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransFactorEntity orderTransFactorEntity = new OrderTransFactorEntity();
		orderTransFactorEntity.setId(id);
		return orderTransFactorEntity;
	}
	
}
