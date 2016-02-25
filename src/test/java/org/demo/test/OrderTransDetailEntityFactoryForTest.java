package org.demo.test;

import org.demo.bean.jpa.OrderTransDetailEntity;

public class OrderTransDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransDetailEntity newOrderTransDetailEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransDetailEntity orderTransDetailEntity = new OrderTransDetailEntity();
		orderTransDetailEntity.setId(id);
		return orderTransDetailEntity;
	}
	
}
