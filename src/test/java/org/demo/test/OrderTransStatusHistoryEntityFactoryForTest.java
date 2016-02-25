package org.demo.test;

import org.demo.bean.jpa.OrderTransStatusHistoryEntity;

public class OrderTransStatusHistoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransStatusHistoryEntity newOrderTransStatusHistoryEntity() {

		Integer id = mockValues.nextInteger();

		OrderTransStatusHistoryEntity orderTransStatusHistoryEntity = new OrderTransStatusHistoryEntity();
		orderTransStatusHistoryEntity.setId(id);
		return orderTransStatusHistoryEntity;
	}
	
}
