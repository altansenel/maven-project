package org.demo.test;

import org.demo.bean.OrderTransStatusHistory;

public class OrderTransStatusHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransStatusHistory newOrderTransStatusHistory() {

		Integer id = mockValues.nextInteger();

		OrderTransStatusHistory orderTransStatusHistory = new OrderTransStatusHistory();
		orderTransStatusHistory.setId(id);
		return orderTransStatusHistory;
	}
	
}
